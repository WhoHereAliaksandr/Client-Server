package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowEvent;

public class View extends JFrame {

    private final int WIDTH = 500, HEIGHT = 500;
    private JLabel labelTitleNews;
    private JPanel panel;
    private JTextArea allNews;
    private JScrollPane scrollAllNews;


    public View() {
        labelTitleNews = new JLabel("  Новости");
        panel = new JPanel();
        allNews = new JTextArea();
        panel.setLayout(null);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

        labelTitleNews.setBorder(border);
        labelTitleNews.setFont(new Font("TimesRoman", Font.PLAIN, HEIGHT / 30));
        labelTitleNews.setBounds(10, 10, WIDTH - 35, labelTitleNews.getFont().getSize() * 2);
        panel.add(labelTitleNews);


        allNews.setFont(new Font("TimesRoman", Font.PLAIN, HEIGHT / 40));
        allNews.setLineWrap(true);
        allNews.setEditable(false);
        scrollAllNews = new JScrollPane(allNews,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollAllNews.setBorder(border);
        scrollAllNews.setBounds(10, labelTitleNews.getBounds().y + labelTitleNews.getBounds().height, WIDTH - 35, 4 * HEIGHT / 5);
        panel.add(scrollAllNews);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - WIDTH / 2, dim.height / 2 - HEIGHT / 2);
        this.setTitle("Клиент");
        this.setResizable(false);
        this.setSize(WIDTH, HEIGHT);
        this.add(panel);
        this.setVisible(true);
    }

    public JTextArea getAllNews() {
        return allNews;
    }

}
