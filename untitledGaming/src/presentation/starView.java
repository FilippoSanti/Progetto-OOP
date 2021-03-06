package presentation;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class starView extends JPanel {
    public starView() {
        super(new GridLayout(2, 2, 4, 4));

    }

    public JPanel makeStarRatingPanel(String title, final LevelBar label) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.add(label);
        return p;
    }

    public static ImageIcon makeStarImageIcon(ImageProducer ip, float rf, float gf, float bf) {
        return new ImageIcon(Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(ip, new SelectedImageFilter(rf, gf, bf))));
    }

}

class LevelBar extends JPanel implements MouseListener, MouseMotionListener {

    private final int gap;
    protected final List<ImageIcon> iconList;
    protected final List<JLabel> labelList = Arrays.asList(
            new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel()
    );
    protected final ImageIcon defaultIcon;
    private int clicked = -1;

    protected LevelBar(ImageIcon defaultIcon, List<ImageIcon> list, int gap) {
        super(new GridLayout(1, 5, gap * 4, gap * 4));
        this.defaultIcon = defaultIcon;
        this.iconList = list;
        this.gap = gap;
        for (JLabel l : labelList) {
            l.setIcon(defaultIcon);
            add(l);
        }
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public int getLevel() {
        return clicked;
    }

    public void clear() {
        clicked = -1;
        repaintIcon(clicked);
    }

    public void setLevel(int l) {
        clicked = l;
        repaintIcon(clicked);
    }

    private int getSelectedIconIndex(Point p) {
        for (int i = 0; i < labelList.size(); i++) {
            Rectangle r = labelList.get(i).getBounds();
            r.grow(gap, gap);
            if (r.contains(p)) {
                return i;
            }
        }
        return -1;
    }

    protected void repaintIcon(int index) {
        for (int i = 0; i < labelList.size(); i++) {
            labelList.get(i).setIcon(i <= index ? iconList.get(i) : defaultIcon);
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        /* not needed */
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        /* not needed */
    }

    @Override
    public void mouseClicked(MouseEvent e) { /* not needed */ }

    @Override
    public void mouseExited(MouseEvent e) {
        /* not needed */
    }

    @Override
    public void mouseDragged(MouseEvent e) { /* not needed */ }

    @Override
    public void mousePressed(MouseEvent e) { /* not needed */ }

    @Override
    public void mouseReleased(MouseEvent e) { /* not needed */ }
}

class SelectedImageFilter extends RGBImageFilter {
    private final float rf;
    private final float gf;
    private final float bf;

    protected SelectedImageFilter(float rf, float gf, float bf) {
        super();
        this.rf = Math.min(1f, rf);
        this.gf = Math.min(1f, gf);
        this.bf = Math.min(1f, bf);
        canFilterIndexColorModel = false;
    }

    @Override
    public int filterRGB(int x, int y, int argb) {
        int r = (int) (((argb >> 16) & 0xFF) * rf);
        int g = (int) (((argb >> 8) & 0xFF) * gf);
        int b = (int) (((argb) & 0xFF) * bf);
        return (argb & 0xFF000000) | (r << 16) | (g << 8) | (b);
    }


}

