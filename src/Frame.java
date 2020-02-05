import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/* The main graphics class.
 */

public class Frame extends JPanel implements ActionListener, MouseWheelListener {
	private int size, width, height;
	private SortIterator iter;
	private JFrame w;
	private Timer t;
	private JButton startBtn, browseBtn;
	private JComboBox<String> sortingMethodsBox;
	private Image img;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new Frame();
		});
	}
	
	Frame() {
		size = 15;
		width = 117;
		height = 34;
		
		iter = new SortIterator();
		
		t = new Timer(1, this);
		
		setPreferredSize(new Dimension(width, height));
		setFocusable(true);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setFocusTraversalKeysEnabled(false);
		
		addMouseWheelListener(this);
		
		// setup all buttons and checkbox
		setupAll();
		
		add(browseBtn);
		
		w = new JFrame("Sorting Algorithms Visualization");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setContentPane(this);
		w.setResizable(false);
		w.pack();
		w.setLocationRelativeTo(null);
		w.setVisible(true);
	}
	
	private void setupAll() {
		startBtn = new JButton("start");
		startBtn.setMargin(new Insets(0, 0, 0, 0));
		startBtn.setVisible(true);
		startBtn.setFocusable(false);
		startBtn.addActionListener(this);
		
		String sortMethods[] = {"Bubble sort", "Insertion sort", "Quick sort", "Selection sort", 
							"Cocktail sort", "Merge sort", "Shell sort", "Randomly"};
		sortingMethodsBox = new JComboBox<>(sortMethods);
		sortingMethodsBox.setFocusable(false);
		sortingMethodsBox.addItemListener((n) -> {
			iter.setSortingMethod((String) sortingMethodsBox.getSelectedItem());
			sortingMethodsBox.setPopupVisible(false);
		});
		sortingMethodsBox.setVisible(true);
		
		browseBtn = new JButton("Browse image");
		browseBtn.setMargin(new Insets(0, 0, 0, 0));
		browseBtn.setVisible(true);
		browseBtn.setFocusable(false);
		browseBtn.addActionListener((e) -> {
			FileDialog fd = new FileDialog(w, "Choose an image", FileDialog.LOAD);
			
			fd.setFilenameFilter((dir, name) -> name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png"));
            fd.setVisible(true);

			String filename = fd.getFile();
			
			if (filename != null) {
				String path = fd.getDirectory() + fd.getFile();
				
				img = new Image(path, size);
				
				if(t.isRunning()) {
					t.stop();					
				}
				startBtn.setText("shuffle");
				
				int newWidth = img.getImage().getWidth() - img.getImage().getWidth()%size;
				int newHeight = img.getImage().getHeight() - img.getImage().getHeight()%size;

				width = newWidth;
				height = newHeight;
				
			    setPreferredSize(new Dimension(width, height));
				
        		add(sortingMethodsBox);
        		add(startBtn);
                revalidate();
                w.pack();
        		w.setLocationRelativeTo(null);
        		
                repaint();
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// if image is selected
		if(img != null) {
			
			//draw shuffled subimages
			for(int i = 0; i < img.getPixels().size(); i++) {
				for(int j = 0; j < img.getPixels().get(i).size(); j++) {
					g.drawImage(img.getPixels().get(i).get(j).getSubimage(), j*size, i*size, null);
				}
			}
			
			//draw background for menu
			g.setColor(new Color(0, 0, 0, 170));
			g.fillRect(0, 0, 310, 40);
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int value = -e.getWheelRotation();
		
		if((size > 45 && value == 1) 
				| (size <= 8 && value == -1)) {
			return;			
		}
		
		size += value;
		
		img.generatePixels(size);
		img.shuffle();
		
		if(startBtn.getText().equals("shuffle")) {
			startBtn.setText("start");
		}
		
		int newWidth = img.getImage().getWidth() - img.getImage().getWidth()%size;
		int newHeight = img.getImage().getHeight() - img.getImage().getHeight()%size;

		width = newWidth;
		height = newHeight;
		
	    setPreferredSize(new Dimension(width, height));
		
		w.pack();
		
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String value = arg0.getActionCommand();
		
		// check if method is called by timer or buttons
		if (value == null) {
			
			if(iter.isSorted()) {
				t.stop();
				startBtn.setText("shuffle");
			} else {
				iter.sort(img.getPixels());	
			}
			
		} else {
			
			if(value.equals("start")) {
				startBtn.setText("stop");
				iter.sort(img.getPixels());
				t.start();
			} else if(value.equals("stop")) {
				startBtn.setText("start");				
				t.stop();
			} else if(value.equals("shuffle")) {
				img.shuffle();
				startBtn.setText("start");
			}
		}
		
		repaint();
	}	
}
