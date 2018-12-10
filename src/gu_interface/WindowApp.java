package gu_interface;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class WindowApp extends JFrame {
    public WindowApp() throws HeadlessException {
        super("ProgectManager");
        initWindow();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setJMenuBar(createMenuBar());
        add(createSplitPane());

        // В левую панель добавляем дерево
        // В правую панель добавляем таблицу с результатами запросов
        // Строку состояния в низ окна с прогрессбаром?

//        JPanel content = new JPanel();
//        content.setBorder(new TitledBorder("Дерево проектов"));
//        add(content);


//        pack();
        setVisible(true);
    }

    private JSplitPane createSplitPane() {
//        JSplitPane splitPane = new JSplitPane();
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
        splitPane.setOneTouchExpandable(true);
        splitPane.setLeftComponent(new JScrollPane());
        splitPane.setDividerLocation(((int) getDimension().getWidth()) / 8);
        splitPane.setRightComponent(new JScrollPane());
        return splitPane;
    }

    private Dimension getDimension() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = new Dimension(toolkit.getScreenSize());
        return dimension;
    }

    private void initWindow() {
//        JFrame.setDefaultLookAndFeelDecorated(true);
        int height = (int) getDimension().getHeight();
        int width = (int) getDimension().getWidth();
        setSize(width / 2, height / 2);
        setLocation(width / 2 - getWidth() / 2, height / 2 - getHeight() / 2);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        menuBar.add(createDoMenu());

        return menuBar;
    }

    private JMenu createFileMenu() {
        JMenu fileMenu = new JMenu("Файл");
//        fileMenu.setMnemonic('Ф');
        fileMenu.setMnemonic(KeyEvent.VK_A);
        fileMenu.getAccessibleContext().setAccessibleDescription("Вызван метод setAccessibleDescription"); // Что это?
        JMenuItem openItem = new JMenuItem("Открыть");
//        JMenuItem openItem = new JMenuItem("Открыть", new ImageIcon(""));
        JMenuItem exitItem = new JMenuItem("Выход");
        exitItem.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exitItem.setName("Выход");
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        return fileMenu;
    }

    private JMenu createDoMenu() {
        JMenu doMenu = new JMenu("Запросы");
        doMenu.setMnemonic(KeyEvent.VK_D);
//        doMenu.getAccessibleContext().setAccessibleDescription("Вызван метод setAccessibleDescription"); // Что это?
        JMenuItem query1 = new JMenuItem("Показать все задачи");
        JMenuItem query2 = new JMenuItem("Показать незавершенные задачи");
        JMenuItem query3 = new JMenuItem("Показать завершенные задачи");
        JMenuItem query4 = new JMenuItem("Показать задачи пользователя");
        doMenu.add(query1);
        doMenu.add(query2);
        doMenu.add(query3);
        doMenu.add(query4);
        return doMenu;
    }
}