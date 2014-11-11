/* TEMPERATURE CONVERTER
 * 
 * A simple temperature conversion appication, controlled by a slider,
 * which displays both temperature values below the slider.
 * 
 * Author:		Scott Boggs
 * Class:		Intro to Java
 * Created on:	2014-10-23
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.text.*;

public class TemperatureConverter extends JFrame{
	//declaration section
	JSlider temperatureJSlider;
	JPanel titleJPanel;
	JTextField fahrenheitJTextField;
	JTextField celsiusJTextField;
	JLabel fahrenheitJLabel;
	JLabel celsiusJLabel;
	JButton closeJButton;
	
	double fahrenheitDegrees;
	double celsiusDegrees;
	
	DecimalFormat rounding;
	
	//this is invoked when the main method is invoked (or maybe the main class, frankly I'm not sure), which in turn runs createUserInterface
	public TemperatureConverter(){
		createUserInterface();
	}
	//creates the user interface.
	public void createUserInterface(){
		//creates the window
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		
		//initialize components section
		temperatureJSlider = new JSlider(JSlider.HORIZONTAL,0,100,0);
		temperatureJSlider.setBounds(25,20,300,100);
		temperatureJSlider.setForeground(Color.BLACK);
		temperatureJSlider.setPaintTicks(true);
		temperatureJSlider.setMajorTickSpacing(10);
		temperatureJSlider.setMinorTickSpacing(5);
		temperatureJSlider.setPaintLabels(true);
		contentPane.add(temperatureJSlider);
		temperatureJSlider.addChangeListener(
			new ChangeListener(){
				public void stateChanged(ChangeEvent event){
					temperatureJSliderStateChanged(event);
				}
			}
		);
		fahrenheitJLabel = new JLabel();
		fahrenheitJLabel.setBounds(100, 200, 100, 20);
		fahrenheitJLabel.setFont(new Font( "Default", Font.PLAIN, 12));
		fahrenheitJLabel.setText("Fahrenheit: ");
		fahrenheitJLabel.setForeground(Color.BLACK);
		fahrenheitJLabel.setHorizontalAlignment(JLabel.LEFT);
		contentPane.add(fahrenheitJLabel);

		fahrenheitJTextField = new JTextField();
		fahrenheitJTextField.setBounds(200, 200, 100, 20);
		fahrenheitJTextField.setFont(new Font( "Default", Font.PLAIN, 18));
		fahrenheitJTextField.setHorizontalAlignment(JTextField.CENTER);
		fahrenheitJTextField.setForeground(Color.BLACK);
		fahrenheitJTextField.setBackground(Color.WHITE);
		fahrenheitJTextField.setEditable(false);
		contentPane.add(fahrenheitJTextField);
		
		celsiusJLabel = new JLabel();
		celsiusJLabel.setBounds(100, 220, 100, 20);
		celsiusJLabel.setFont(new Font( "Default", Font.PLAIN, 12));
		celsiusJLabel.setText("Celsius ");
		celsiusJLabel.setForeground(Color.BLACK);
		celsiusJLabel.setHorizontalAlignment(JLabel.LEFT);
		contentPane.add(celsiusJLabel);

		celsiusJTextField = new JTextField();
		celsiusJTextField.setBounds(200, 220, 100, 20);
		celsiusJTextField.setFont(new Font( "Default", Font.PLAIN, 18));
		celsiusJTextField.setHorizontalAlignment(JTextField.CENTER);
		celsiusJTextField.setForeground(Color.BLACK);
		celsiusJTextField.setBackground(Color.WHITE);
		celsiusJTextField.setEditable(false);
		contentPane.add(celsiusJTextField);
		
		closeJButton = new JButton();
		closeJButton.setBounds(130, 300, 100, 20);
		closeJButton.setFont(new Font("Default",Font.PLAIN,12));
		closeJButton.setText("Close");
		closeJButton.setBackground(Color.WHITE);
		closeJButton.setForeground(Color.BLACK);
		contentPane.add(closeJButton);
		closeJButton.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent event){
					closeJButtonActionPerformed(event);
				}
			}
		);
		
		setTitle("Temperature Converter");
		setSize(400,400);
		setVisible(true);
	}
	//This method listens for a change in the slider.
	public void temperatureJSliderStateChanged(ChangeEvent event){
		rounding = new DecimalFormat("0.0");
		fahrenheitDegrees=temperatureJSlider.getValue();
		calculateCelsiusTemperature();
	}
	public void calculateCelsiusTemperature(){
		celsiusDegrees=(fahrenheitDegrees - 32.0)*5.0/9.0;
		fahrenheitJTextField.setText("" + rounding.format(fahrenheitDegrees));
		celsiusJTextField.setText("" + rounding.format(celsiusDegrees));
	}
	
	//main method
	public static void main(String[] args){
		TemperatureConverter application = new TemperatureConverter();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//close event handler
	public void closeJButtonActionPerformed(ActionEvent event){
		TemperatureConverter.this.dispose();
	}
}
