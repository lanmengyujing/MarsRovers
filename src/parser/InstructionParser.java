package parser;

public class InstructionParser implements parser {
    private String regEx = "^[L|M|R]*$";
    String instruction;

    @Override
    public void parse(String instruction) {
        instruction = instruction.toUpperCase();
        try {
            Match.matchCondition(regEx, instruction);
            this.instruction = instruction;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The input commands for rover are not valid!");
        }
    }

    public String getInsruction() {
        return instruction;
    }
}
