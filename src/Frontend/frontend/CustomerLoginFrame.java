package frontend;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CustomerLoginFrame extends JFrame{
  private Middleware mwInstance = Middleware.getInstance();
  // make them a higher scope so action listeners can have access to them
  // as well
  private JTextField jtfUsername = new JTextField();
  private JPasswordField jtfPassword = new JPasswordField();
  private JLabel jlbMessage = new JLabel();

  public CustomerLoginFrame() {
    // create buttons
    JButton jbtLogin = new JButton("Login");
    JButton jbtCreateAccount = new JButton("Create Account");
    JButton jbtForgotPassword = new JButton("Forgot Password");

    JLabel jlbUsername = new JLabel("Username:");
    JPanel usernamePanel = new JPanel();
    usernamePanel.setLayout(new GridLayout(0, 2));
    usernamePanel.add(jlbUsername);
    usernamePanel.add(jtfUsername);

    JLabel jlbPassword = new JLabel("Password:");
    JPanel passwordPanel = new JPanel();
    passwordPanel.setLayout(new GridLayout(0, 2));
    passwordPanel.add(jlbPassword);
    passwordPanel.add(jtfPassword);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(6, 0));
    mainPanel.add(usernamePanel);
    mainPanel.add(passwordPanel);
    mainPanel.add(jbtLogin);
    mainPanel.add(jbtCreateAccount);
    mainPanel.add(jbtForgotPassword);
    mainPanel.add(jlbMessage);

    add(mainPanel); // REMEMBER to add mainPanel!!!

    // associate events to each button action
    LoginListener ll = new LoginListener();
    jbtLogin.addActionListener(ll);
    CreateAccountListener cal = new CreateAccountListener();
    jbtCreateAccount.addActionListener(cal);
    RecoverPasswordListener rpl = new RecoverPasswordListener();
    jbtForgotPassword.addActionListener(rpl);
  }

  class LoginListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      String username = jtfUsername.getText();
      // jtfPassword.getPassword() returns char[], and is converted to String
      String password = new String(jtfPassword.getPassword());
      if (mwInstance.login(username, password)) {
        System.out.println("Login success.");
      } else {
        jlbMessage.setText("Login failed.");
        System.out.println("Login failed.");
      }
      System.out.println("Login button clicked");
    }
  }

  class CreateAccountListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      System.out.println("Create Account button clicked");
      CreateCustomerAccountFrame createCustomerAccountFrame = new CreateCustomerAccountFrame();
      createCustomerAccountFrame.showWindow();
    }
  }

  class RecoverPasswordListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      System.out.println("Forgot Password button clicked");
      RecoverPasswordFrame recoverPasswordFrame = new RecoverPasswordFrame();
      recoverPasswordFrame.showWindow();
    }
  }

  public static void showWindow() {
    // create a new frame
    JFrame customerLoginFrame = new CustomerLoginFrame();

    // init frame info
    customerLoginFrame.setTitle( "Customer Login" );
    customerLoginFrame.setSize( 300, 200 );
    customerLoginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE ); 
    customerLoginFrame.setLocationRelativeTo(null); // Center the frame on the screen

    // turn it on 
    customerLoginFrame.setVisible(true);
  }


  // public static void main( String[] args ) {
  //   // create a new frame
  //   JFrame customerLoginFrame = new CustomerLoginFrame();

  //   // init frame info
  //   customerLoginFrame.setTitle( "Customer Login" );
  //   customerLoginFrame.setBounds(0, 0, 300, 200);
  //   customerLoginFrame.setSize( 300, 200 );
  //   customerLoginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE ); 
  //   customerLoginFrame.setLocationRelativeTo(null); // Center the frame on the screen

  //   // turn it on 
  //   customerLoginFrame.setVisible(true);

  //   // // create a window
  //   // JWindow customerLoginWindow = new JWindow();
  //   // customerLoginWindow.add(customerLoginFrame);
  //   // customerLoginWindow.setSize(300, 200); 
  //   // customerLoginWindow.setLocationRelativeTo(null); // Center the frame on the screen
  //   // customerLoginWindow.setVisible(true);
  // }
}
