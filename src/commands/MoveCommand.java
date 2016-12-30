package commands;


import levels.Level;
import policies.Policy;
import utils.Direction;

import java.io.IOException;

public class MoveCommand implements Command{

    protected Level level=null;
    protected Policy policy=null;
    protected Direction direction=null;

    public MoveCommand() {
    }

    public MoveCommand(Level level, Policy policy, Direction direction) throws IOException {
        setLevel(level);
        setPolicy(policy);
        setDirection(direction);
    }


    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) throws IOException {
        if (level==null)
            throw new IOException("Please provide a valid level");
        this.level = level;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) throws IOException {
        if (policy==null)
            throw new IOException("Please provide a valid policy");
        this.policy = policy;
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
        policy.checkPolicy();
    }

    public boolean isVaildDirection(String direction){
        // checks if the provided string is a valid direction (enum)
        for (Direction dir : Direction.values())
            if (dir.name().equals(direction.toUpperCase()))
                return true;

        return false;
    }
}
