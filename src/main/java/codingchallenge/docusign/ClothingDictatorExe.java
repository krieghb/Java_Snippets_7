package codingchallenge.docusign;

/**
 *  @author Krieghbaum
 *
 *  Executing of the ClothingDictator.  Chooses which child based on the String's parse of beginning.
 */
public class ClothingDictatorExe {

    //  Parent class to be extended.
    private ClothingDictator hotCold;
    private String command;

    public ClothingDictatorExe() {
        command = "HOT";
    }

    public ClothingDictatorExe(String command) {
        this.command = command;
    }

    public void newCommand(String command) {
        this.command = command;
    }

    /**
     *  Method to execute the command in the argument by calling no argument version.
     * @param in    String to be parsed and executed on.
     */
    public void executeCommand(String in) {
        this.command = in;
        executeCommand();
    }

    /**
     *  Method to execute the command set in the command variable.
     */
    public void executeCommand() {
        hotCold = new ClothingDictatorHot(command);
        if (Weather.COLD.equals(hotCold.splitCommands(command))) {
            hotCold = new ClothingDictatorCold(command);
        }

        hotCold.decideWeather();
    }


}
