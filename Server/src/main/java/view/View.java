package main.java.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class View extends JFrame {

    private final int WIDTH = 500, HEIGHT = 500;
    private JButton button;
    private JLabel labelTitleAllNews;
    private JLabel labelTitleNewNews;
    private JPanel panel;
    private JTextArea allNews;
    private JTextArea newNews;
    private JScrollPane scrollAllNews;
    private JScrollPane scrollNewNews;


    public View() {
        labelTitleAllNews = new JLabel("  Архив Новостей");
        labelTitleNewNews = new JLabel("  Новая новость");
        panel = new JPanel();
        allNews = new JTextArea();
        newNews = new JTextArea();
        button = new JButton("Опубликовать");
        panel.setLayout(null);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

        labelTitleAllNews.setBorder(border);
        labelTitleAllNews.setFont(new Font("TimesRoman", Font.PLAIN, HEIGHT / 30));
        labelTitleAllNews.setBounds(0, 10, WIDTH - 35, labelTitleAllNews.getFont().getSize() * 2);
        panel.add(labelTitleAllNews);


        allNews.setFont(new Font("TimesRoman", Font.PLAIN, HEIGHT / 40));
        allNews.setLineWrap(true);
        allNews.setEditable(false);
        scrollAllNews = new JScrollPane(allNews,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollAllNews.setBorder(border);
        scrollAllNews.setBounds(0, labelTitleAllNews.getBounds().y + labelTitleAllNews.getBounds().height, WIDTH - 35, HEIGHT / 4);
        panel.add(scrollAllNews);

        labelTitleNewNews.setBorder(border);
        labelTitleNewNews.setFont(new Font("TimesRoman", Font.PLAIN, HEIGHT / 30));
        labelTitleNewNews.setBounds(0, scrollAllNews.getBounds().y + scrollAllNews.getBounds().height + HEIGHT / 25, WIDTH - 35, labelTitleNewNews.getFont().getSize() * 2);
        panel.add(labelTitleNewNews);


        newNews.setFont(new Font("TimesRoman", Font.PLAIN, HEIGHT / 40));
        newNews.setLineWrap(true);
        scrollNewNews = new JScrollPane(newNews,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollNewNews.setBorder(border);
        scrollNewNews.setBounds(0, labelTitleNewNews.getBounds().y + labelTitleNewNews.getBounds().height, WIDTH - 35, HEIGHT / 4);
        panel.add(scrollNewNews);

        button.setFont(new Font("TimesRoman", Font.PLAIN, HEIGHT / 30));
        button.setLocation(2 * WIDTH / 3 - 35, scrollNewNews.getBounds().y + scrollNewNews.getBounds().height + HEIGHT / 20);
        button.setSize(WIDTH / 3, button.getFont().getSize() * 3);
        panel.add(button);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - WIDTH / 2, dim.height / 2 - HEIGHT / 2);
        this.setTitle("Сервер");
        this.setResizable(false);
        this.setSize(WIDTH, HEIGHT);
        this.add(panel);
        this.setVisible(true);
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public JTextArea getAllNews() {
        return allNews;
    }

    public void setAllNews(JTextArea allNews) {
        this.allNews = allNews;
    }

    public JTextArea getNewNews() {
        return newNews;
    }

    public void setNewNews(JTextArea newNews) {
        this.newNews = newNews;
    }
}
