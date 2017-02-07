import java.awt.*;
import java.awt.event.*;
import java.lang.Math;


public class Calculator extends Frame implements ActionListener
{
	TextField inp,ans;
	Label blank,bmn;
	Button b;
	String s[];
	char symbol;
	int pp1;
	
	
	public Calculator()
	{
         inp = new TextField(25);
         ans = new TextField(25);
         blank = new Label(" ");
         bmn = new Label("");
         setLayout(new GridLayout(6,4,10,10));
         add(inp);
         add(ans);
         add(blank);
         add(bmn);
         
         String s1[] = {"7","8","9","+","4","5","6","-","1","2","3","*","0",".","+/-","/","sq. root","OFF","AC","="};
         s = s1;
         for(int i = 0;i<s.length;i++)
         {
              b = new Button(s[i]);
              add(b);
              b.addActionListener(this);
         }
         inp.setEditable(false);
         inp.setText("0");
         ans.setEditable(false);
         ans.setText("0");
         addWindowListener(new MyWindowAdapter());
    }
     
    public void digitPressed(String i)
    {
         String inpt = inp.getText();
         if(pp1<1)
        {
         int a = Integer.parseInt(inpt);
         int b = Integer.parseInt(i);
         a = a*10 + b;
         inpt = String.valueOf(a);
         inp.setText(inpt);
        }
        else
        {

         inp.setText(inpt + i);
        }
    }
    public void addPressed(char symbol1)
    {
         
         String inpt = inp.getText();
         double d = Double.parseDouble(inpt);
         String ab = ans.getText();
         double n = Double.parseDouble(ab);
         double y = Calculate(d,symbol1,n);
         inpt = String.valueOf(y);
         ans.setText(inpt);
         symbol = '+';
         inp.setText("0");
    }
    
    public double Calculate(double yt,char hy,double ty)
    {
         switch(hy)
         {
               case '+': yt += ty;
                         break;
               case '-': yt = ty - yt;
                         break;
               case '*': yt *= ty;
                         break;          
              case '/': yt = ty / yt;
                         break;
              case'=' : yt = ty;
                         break;
              default: ty = yt;
                       break;
       }
       pp1  = 0;
       return yt;
    }
    public void subPressed(char symbol1)
    {
         
         String inpt = inp.getText();
         double d = Double.parseDouble(inpt);
         double n = Double.parseDouble(ans.getText());
         double y = Calculate(d,symbol1,n);
         inpt = String.valueOf(y);
         ans.setText(inpt);
         symbol = '-';
         inp.setText("0");
    }
   
    public void mulPressed(char symbol1)
    {
         
         String inpt = inp.getText();
         double d = Double.parseDouble(inpt);
         double n = Double.parseDouble(ans.getText());
         double y = Calculate(d,symbol1,n);
         inpt = String.valueOf(y);
         ans.setText(inpt);
         symbol = '*';
         inp.setText("0");
    }
    public void divPressed(char symbol1)
    {
         
         String inpt = inp.getText();
         double d = Double.parseDouble(inpt);
         double n = Double.parseDouble(ans.getText());
         double y = Calculate(d,symbol1,n);
         inpt = String.valueOf(y);
         ans.setText(inpt);
         symbol = '/';
         inp.setText("0");
    }
    public void equalPressed(char symbol1)
    {
         
         String inpt = inp.getText();
         double d = Double.parseDouble(inpt);
         double n = Double.parseDouble(ans.getText());
         double y = Calculate(d,symbol1,n);
         inpt = String.valueOf(y);
         ans.setText(inpt);
         inp.setText("0");
    }
    
    public void unaryPressed()
    {
         String inpt = inp.getText();
         double d = Double.parseDouble(inpt);
         d = -d;
         inpt = String.valueOf(d);
         inp.setText(inpt);
   }
         
	
	public void rootPressed()
	{
	     
         String inpt = inp.getText();
         double d = Double.parseDouble(inpt);
         d = Math.sqrt(d);
         inpt = String.valueOf(d);
         inp.setText(inpt);
    }
   
   
    public void offPressed()
    {
         System.exit(0);
    }
    
    
    public void ACPressed()
    {
        inp.setText("0");
        ans.setText("0");
        pp1 = 0;
        symbol = ' ';
    }
    
    public void pointPressed()
    {
         if(pp1<1)
         {
              String inpt = inp.getText();
              inpt += ".";
              inp.setText(inpt);
              pp1++;
         }
    }
	public void actionPerformed(ActionEvent ae) 
	{
	    String res = ae.getActionCommand();
	    
	    if(res.equals("+"))
	          addPressed(symbol);
	    if(res.equals("-"))
	          subPressed(symbol);	    
	    if(res.equals("*"))
	          mulPressed(symbol);          
	    if(res.equals("/"))
	          divPressed(symbol);
	    if(res.equals("."))
	          pointPressed();
	    if(res.equals("+/-"))
	          unaryPressed();
	    if(res.equals("sq. root"))
	          rootPressed();
	    if(res.equals("OFF"))
	          offPressed();
	    if(res.equals("AC"))
	          ACPressed();
	    if(res.equals("="))
	          equalPressed(symbol);
	    else
	    {
	        for(int j = 0;j < 10;j++)
	        {
	            String nios = String.valueOf(j);
	            if(res.equals(nios))
	            {
	                digitPressed(nios);
	                break;
	            }
	         }
	   }
 }
}