package controller.command;


import model.Model;
import model.data.level.Level;
import model.policy.Policy;
import utils.Direction;

import java.io.IOException;

public class MoveCommand implements Command{

    protected Model model;
    protected Direction direction=null;

    public MoveCommand() {
    }

    public MoveCommand(Model model, Direction direction) throws IOException {
        setModel(model);
        setDirection(direction);
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) throws IOException {
        if (model==null)
            throw new IOException("Please provide a valid model");
        this.model = model;
    }


    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) throws IOException {
        if (direction==null)
            throw new IOException("Please provide a valid direction");
        this.direction = direction;
    }

    @Override
    public void execute() throws IOException {
        model.move(direction);
    }

    public boolean isVaildDirection(String direction){
        // checks if the provided string is a valid direction (enum)
        for (Direction dir : Direction.values())
            if (dir.name().equals(direction.toUpperCase()))
                return true;

        return false;
    }
}
