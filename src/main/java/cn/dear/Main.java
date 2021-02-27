package cn.dear;

import cn.dear.util.Recording;

import lombok.extern.slf4j.Slf4j;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 功能描述
 *
 * @since 2021-02-22
 */
@Slf4j
public class Main {
    private final static ExecutorService executorService = Executors.newFixedThreadPool(5);

    // 开始结束时间
    private static volatile Map<String, Recording> time = new HashMap<>();

    public static String getProjectPath() {
        java.net.URL url = Main.class.getProtectionDomain().getCodeSource().getLocation();
        String filePath = null;
        try {
            filePath = java.net.URLDecoder.decode(url.getPath(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (filePath.endsWith(".jar")) {
            filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
        }
        java.io.File file = new java.io.File(filePath);
        filePath = file.getAbsolutePath();
        return filePath;
    }

    public static void main(String[] args) {

        // if (args.length==0){
        // log.error("输入处理类型：", "1111");
        // }
        // String type = args[0];
        //
        // String rootPath = getProjectPath();
        // log.info("当前处理目录：" + rootPath);
        // switch (type){
        // case "1":
        // System.out.println(1);
        // break;
        // }
        // log.info("测试使用日志功能");
        createGui3();
    }

    public static void createGui() {
        JFrame demo = new JFrame("demo");
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = demo.getContentPane();
        contentPane.setLayout(new FlowLayout());

        contentPane.add(new JLabel("你好"));
        contentPane.add(new JLabel("你好2"));
        contentPane.add(new JButton("测试"));

        demo.setSize(400, 600);

        // 显示窗口
        demo.setVisible(true);
        contentPane.add(new JButton("测试"));
    }

    public static void createGui2() {
        try {
            //设置显示
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame demo = new JFrame("demo");
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = demo.getContentPane();
        //布局管理器，流布局
        contentPane.setLayout(new FlowLayout());

//        //边界布局
//        contentPane.setLayout(new BorderLayout());
//        //单文本框
//        JTextField textField = new JTextField(16);
//        //是否禁用文本框
//        textField.setEnabled(true);
//        textField.setPreferredSize(new Dimension(0,100));
//        contentPane.add(textField,BorderLayout.PAGE_START);

//创建菜单
        JMenuBar jMenuBar = new JMenuBar();
        JMenu menu = new JMenu("处理");
        JMenuItem jMenuItem = new JMenuItem("分类");
        menu.add(jMenuItem);
        JMenuItem jMenuItem2 = new JMenuItem("分类2");
        menu.addSeparator();
        menu.add(jMenuItem2);

//        //退出
//        System.exit(0);



        jMenuBar.add(menu);
        demo.setJMenuBar(jMenuBar);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String format = dateFormat.format(new Date());
        JLabel label = new JLabel(format);
        contentPane.add(label);
        showTime(label);

        JTextField text = new JTextField(16);
        JButton button = new JButton("测试");
        button.addActionListener((e)->{
            chooseFile(demo,text);
        });
        contentPane.add(button);
        contentPane.add(text);

        //单文本框
        JTextField textField = new JTextField(16);
        //是否禁用文本框
        textField.setEnabled(true);
        contentPane.add(textField);

        //复选框
        JCheckBox jCheckBox = new JCheckBox("复选框");
        //设置默认
        jCheckBox.setSelected(true);
        contentPane.add(jCheckBox);

        //下拉框
        JComboBox<String> jComboBox = new JComboBox<>();
        jComboBox.addItem("1");
        jComboBox.addItem("2");
        jComboBox.addItem("3");
        jComboBox.addItem("4");
        //
        int selectedIndex = jComboBox.getSelectedIndex();
        jComboBox.setSelectedIndex(0);
//        jComboBox.remove(0);

        contentPane.add(jComboBox);


        demo.setSize(400, 600);

        // 显示窗口
        demo.setVisible(true);

    }

    public static void createGui3() {
        try {
            //设置显示
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame demo = new JFrame("dear");
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = demo.getContentPane();
//        demo.setLayout(new GridLayout(10, 10));

        //布局管理器，流布局
//        contentPane.setLayout(new FlowLayout());
        contentPane.setLayout(new BorderLayout());

        demo.setSize(400, 1000);
        demo.setMinimumSize(new Dimension(400, 300));
        demo.setMaximumSize(new Dimension(1000,1000));
        demo.setLocation(0,0);

        //单文本框
        JTextField textField = new JTextField(16);
        //是否禁用文本框
        textField.setEnabled(true);
        contentPane.add(textField);

        JTextField text = new JTextField(16);
        JButton button = new JButton("浏览");
        button.addActionListener((e)->{
            chooseFile(demo,text);
        });
        contentPane.add(button);
        contentPane.add(text);

        //下拉框
        JComboBox<String> jComboBox = new JComboBox<>();
        jComboBox.addItem("1");
        jComboBox.addItem("2");
        jComboBox.addItem("3");
        jComboBox.addItem("4");
        //
        int selectedIndex = jComboBox.getSelectedIndex();
        jComboBox.setSelectedIndex(0);
//        jComboBox.remove(0);

        contentPane.add(jComboBox);




        JTextArea area = new JTextArea(3, 10);// 构造一个文本域
        area.setLineWrap(true);//如果内容过长，自动换行，在文本域加上滚动条，水平和垂直滚动条始终出现。
        JLabel labe = new JLabel("构造文本域:");
        labe.setBounds(100, 10, 120, 20);
        area.setBounds(130, 10, 150, 100);
        contentPane.add(labe);
        contentPane.add(area);
        area.setText("SLF4J: Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".\n" +
                "SLF4J: Defaulting to no-operation (NOP) logger implementation\n" +
                "SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.SLF4J: Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".\n" +
                "SLF4J: Defaulting to no-operation (NOP) logger implementation\n" +
                "SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
        JScrollPane pane=new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        demo.add(pane);

        JLabel label = new JLabel();
        label.setBounds(10, demo.getHeight()-100, 500, 20);
        label.setFont(new Font("Comic Sans Ms", 0, 20));
        label.setForeground(Color.CYAN);
        showTime(label);
        contentPane.add(BorderLayout.PAGE_END,label);

        // 显示窗口
        demo.setVisible(true);

    }

    private static void chooseFile(JFrame demo,JTextField textField) {
        //文件选择或目录
        JFileChooser jFileChooser = new JFileChooser();
        //过滤文件
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("所有文件");
//        jFileChooser.setFileFilter(filter);
        //显示对话框
        int ret = jFileChooser.showOpenDialog(demo);
        if (ret==JFileChooser.APPROVE_OPTION){
            File file = jFileChooser.getSelectedFile();
            String absolutePath = file.getAbsolutePath();
            textField.setText(absolutePath);
        }
    }

    public static void showTime(JLabel label) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String format = dateFormat.format(new Date());
                label.setText(format);
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);
    }

    // 监听处理
    public static void listener(JButton button) {
        // 创建监听器 监听器添加给按钮
        button.addActionListener((e)->{});

    }

    // 记录开始时间
    public static void startTime(JLabel label) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String format = dateFormat.format(new Date());
        label.setText(format);

        label.setFont(new Font("微软雅黑", 0, 14));
        label.setForeground(Color.CYAN);
        label.setToolTipText("提示");
    }

    // 计算当前使用时间
    public static void useTime(String token, JLabel label) {
        Recording recording = time.get(token);
        long useTime = System.currentTimeMillis() - recording.getStart();
        label.setText(useTime + "");
    }

    // 计算总共使用时间
    public static void useTotalTime(String token, JLabel label) {
        Recording recording = time.get(token);
        long useTime = recording.getNow() - recording.getStart();
        label.setText(useTime + "");
    }

    //回调

    //单行文本框
    public static void one() {
        JTextField textField = new JTextField(16);

        return;
    }

    //消息提示框
    public static void two(String[] args) {
//        JOptionPane.showMessageDialog(this, "输入了");
    }
}
