package commands;


import levels.Level;
import policies.Policy;
import utils.Direction;

import java.io.IOException;

public class MoveCommand implements Command{

    protected Level level;
    protected Policy policy;
    protected Direction direction;

    public MoveCommand() {
    }

    public MoveCommand(Level level, Policy policy, Direction direction) {
        this.level = level;
        this.policy = policy;
        this.direction = direction;
    }


    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void execute() throws IOException,ClassNotFoundException {
        policy.checkPolicy();
    }
}
