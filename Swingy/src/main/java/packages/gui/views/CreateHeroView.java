package packages.gui.views;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import packages.models.HeroModel;
import packages.enums.CharacterType;
import packages.utils.JFrameHelper;
import packages.utils.Log;

public class CreateHeroView extends JFrame{
    private JLabel lblHeroImage;
    private JButton btnSelectHeroImage;
    private JButton btnCreateHero;
    private JButton btnCanel;
    private JTextField txtFdName;
    private JComboBox<CharacterType> listFdType;
    private JTextField txtFdLevel;
    private JTextField txtFdXPoints;
    private JTextField txtFdWeapon;
    private JTextField txtFdArmor;
    private HeroModel newHero = null;
    private String _heroImagePath = "";
    Font titlefont = new Font("Times New Roman", Font.BOLD, 15);
    
    public CreateHeroView(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Create Your Hero");
        this.setSize(500, 350);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.init();
    }

    private void init(){
        JPanel panelMain = new JPanel();
        JPanel panelTop = new JPanel();
        JPanel panelMid = new JPanel();
        JPanel panelBottom = new JPanel();
        JPanel panelTop1 = new JPanel();
        JLabel lblName = new JLabel("Name:");
        this.txtFdName = new JTextField(10);
        JPanel panelTop2 = new JPanel();
        JLabel lblType = new JLabel("Type:");
        this.listFdType = new JComboBox<CharacterType>(CharacterType.values());
        this.listFdType.removeItem(CharacterType.enemy);
        JPanel panelTop3 = new JPanel();
        JLabel lblLevel = new JLabel("Level:");
        this.txtFdLevel = new JTextField(10);
        JPanel panelTop4 = new JPanel();
        JLabel lblXPoints = new JLabel("X-Points:");
        this.txtFdXPoints = new JTextField(8);
        JPanel panelTop5 = new JPanel();
        JLabel lblWeapon = new JLabel("Weapon:");
        this.txtFdWeapon = new JTextField(9);
        JPanel panelTop6 = new JPanel();
        JLabel lblArmor = new JLabel("Armor:");
        this.txtFdArmor = new JTextField(9);
        this.lblHeroImage = new JLabel();
        this.btnSelectHeroImage = new JButton("Select Hero Image");
        btnSelectHeroImage.setFont(titlefont);
        this.btnCreateHero = new JButton("Create Hero");
        this.btnCanel = new JButton("Cancel");

        panelMain.setLayout(null);
        panelMain.setBounds(0, 0, this.getWidth(), this.getHeight());
        panelTop.setBounds(0, 0, this.getWidth(), 80);
        panelMid.setLayout(new GridLayout(3, 2));
        panelMid.setBounds(0, 80, this.getWidth(), 115);
        this.lblHeroImage.setSize(10, 10);
        panelBottom.setBounds(0, 200, this.getWidth(), 38);


        panelTop.add(this.btnSelectHeroImage);
        panelTop.add(this.lblHeroImage);

        panelTop1.add(lblName);
        panelTop1.add(txtFdName);
        panelMid.add(panelTop1);

        panelTop2.add(lblType);
        panelTop2.add(listFdType);
        panelMid.add(panelTop2);

        lblLevel.setEnabled(false);
        txtFdLevel.setEnabled(false);
        txtFdLevel.setText("0");
        panelTop3.add(lblLevel);
        panelTop3.add(txtFdLevel);
        panelMid.add(panelTop3);

        lblXPoints.setEnabled(false);
        txtFdXPoints.setEnabled(false);
        txtFdXPoints.setText("0");
        panelTop4.add(lblXPoints);
        panelTop4.add(txtFdXPoints);
        panelMid.add(panelTop4);

        lblWeapon.setEnabled(false);
        txtFdWeapon.setEnabled(false);
        txtFdWeapon.setText("bow");
        panelTop5.add(lblWeapon);
        panelTop5.add(txtFdWeapon);
        panelMid.add(panelTop5);

        lblArmor.setEnabled(false);
        txtFdArmor.setEnabled(false);
        txtFdArmor.setText("jacket");
        panelTop6.add(lblArmor);
        panelTop6.add(txtFdArmor);
        panelMid.add(panelTop6);
        panelBottom.add(this.btnCreateHero);
        panelBottom.add(this.btnCanel);
        panelMain.add(panelTop);
        panelMain.add(panelMid);
        panelMain.add(panelBottom);

        this.add(panelMain);
    }

    public void createHeroListener(ActionListener listener){
        this.btnCreateHero.addActionListener(listener);
    }

    public void cancelListener(ActionListener listener){
        this.btnCanel.addActionListener(listener);
    }

    public void selectHeroImageListener(ActionListener listener){
        this.btnSelectHeroImage.addActionListener(listener);
    }

    public String getHeroName(){
        return (this.txtFdName.getText());
    }

    public String getCharacterType(){
        return (this.listFdType.getSelectedItem().toString());
    }

    public void setHeroImagePath(String path)
    {
        this._heroImagePath = path;
        Image image = JFrameHelper.getImage(path, 70);
        this.lblHeroImage.setIcon(new ImageIcon(image));
    }
}