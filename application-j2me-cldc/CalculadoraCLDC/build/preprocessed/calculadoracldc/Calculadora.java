package calculadoracldc;

import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDletStateChangeException;

public class Calculadora extends MIDlet implements CommandListener {

    private Display display;
    private Form form;
    private TextField fieldA;
    private TextField fieldB;
    private StringItem item;
    private Command cmSoma;
    private Command cmSubtracao;
    private Command cmDivisao;
    private Command cmMultiplicacao;
    private Command cmExit;

    public Calculadora() {
    }

    protected void destroyApp(boolean arg0)
            throws MIDletStateChangeException {
    }

    protected void pauseApp() {
    }

    protected void startApp() throws MIDletStateChangeException {
        display = Display.getDisplay(this);
        getFormIndex();

    }

    public void getFormIndex() {
        form = new Form("Calculadora");
        fieldA = new TextField("Valor: ", "", 30, TextField.DECIMAL);
        fieldB = new TextField("Valor: ", "", 15, TextField.DECIMAL);
        item = new StringItem("Resultado: ", "");

        cmSoma = new Command("+", Command.ITEM, 1);
        cmSubtracao = new Command("-", Command.ITEM, 2);
        cmMultiplicacao = new Command("*", Command.ITEM, 3);
        cmDivisao = new Command("/", Command.ITEM, 4);
        cmExit = new Command("Sair", Command.EXIT, 1);

        form.append(fieldA);
        form.append(fieldB);
        form.append(item);

        form.addCommand(cmSoma);
        form.addCommand(cmSubtracao);
        form.addCommand(cmMultiplicacao);
        form.addCommand(cmDivisao);
        form.addCommand(cmExit);

        display.setCurrent(form);
        form.setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmExit) {
            try {
                destroyApp(true);
                notifyDestroyed();
            } catch (MIDletStateChangeException ex) {
                ex.getMessage();
            }
        } else if (c == cmSoma) {
            item.setText(String.valueOf(
                    somar(fieldA.getString(), fieldB.getString())));
        } else if (c == cmSubtracao) {
            item.setText(String.valueOf(
                    subtrair(fieldA.getString(), fieldB.getString())));
        } else if (c == cmMultiplicacao) {
            item.setText(String.valueOf(
                    multiplicar(fieldA.getString(), fieldB.getString())));
        } else {
            item.setText(String.valueOf(
                    dividir(fieldA.getString(), fieldB.getString())));
        }
    }

    private double somar(String valueA, String valueB) {
        return Double.parseDouble(valueA) + Double.parseDouble(valueB);
    }

    private double subtrair(String valueA, String valueB) {
        return Double.parseDouble(valueA) - Double.parseDouble(valueB);
    }

    private double multiplicar(String valueA, String valueB) {
        return Double.parseDouble(valueA) * Double.parseDouble(valueB);
    }

    private double dividir(String valueA, String valueB) {
        return Double.parseDouble(valueA) / Double.parseDouble(valueB);
    }
}