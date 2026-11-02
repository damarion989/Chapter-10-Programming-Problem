interface GuardState {
    void hearNoise();
    void seeEnemy();
    void loseTarget();
    String getName();
}

class IdleState implements GuardState {
    private SentinelGuard guard;

    public IdleState(SentinelGuard guard) {
        this.guard = guard;
    }

    public void hearNoise() {
        System.out.println("Guard heard a noise and is investigating.");
        guard.setState(new PatrollingState(guard));
    }

    public void seeEnemy() {
        System.out.println("Guard spotted the enemy and is attacking.");
        guard.setState(new AttackingState(guard));
    }

    public void loseTarget() {
        System.out.println("No target to lose.");
    }

    public String getName() {
        return "Idle";
    }
}

class PatrollingState implements GuardState {
    private SentinelGuard guard;

    public PatrollingState(SentinelGuard guard) {
        this.guard = guard;
    }

    public void hearNoise() {
        System.out.println("Guard is already on alert.");
    }

    public void seeEnemy() {
        System.out.println("Guard spotted the enemy and is attacking.");
        guard.setState(new AttackingState(guard));
    }

    public void loseTarget() {
        System.out.println("No target to lose.");
    }

    public String getName() {
        return "Patrolling";
    }
}

class AttackingState implements GuardState {
    private SentinelGuard guard;

    public AttackingState(SentinelGuard guard) {
        this.guard = guard;
    }

    public void hearNoise() {
        System.out.println("Guard is too busy fighting to notice the noise.");
    }

    public void seeEnemy() {
        System.out.println("Guard spotted the enemy and is attacking.");
    }

    public void loseTarget() {
        System.out.println("Guard is searching for the escaped enemy.");
        guard.setState(new PatrollingState(guard));
    }

    public String getName() {
        return "Attacking";
    }
}


class SleepingState implements GuardState {
    private SentinelGuard guard;

    public SleepingState(SentinelGuard guard) {
        this.guard = guard;
    }

    public void hearNoise() {
        System.out.println("Guard wakes up and starts patrolling.");
        guard.setState(new PatrollingState(guard));
    }

    public void seeEnemy() {
        System.out.println("The guard is snoring loudly and doesn’t see a thing.");
    }

    public void loseTarget() {
        System.out.println("The guard is fast asleep and doesn’t care about targets.");
    }

    public String getName() {
        return "Sleeping";
    }
}

class SentinelGuard {
    private GuardState currentState;

    public SentinelGuard() {
        currentState = new IdleState(this);
    }

    public void setState(GuardState state) {
        currentState = state;
    }

    public void hearNoise() {
        currentState.hearNoise();
    }

    public void seeEnemy() {
        currentState.seeEnemy();
    }

    public void loseTarget() {
        currentState.loseTarget();
    }

    public void printState() {
        System.out.println("Current state: " + currentState.getName());
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        SentinelGuard guard = new SentinelGuard();

        System.out.println("=== Sleeping Simulation ===");

        guard.setState(new SleepingState(guard));
        guard.printState();

        
        guard.seeEnemy();
        guard.printState();

        guard.loseTarget();
        guard.printState();

        
        guard.hearNoise();
        guard.printState();

        guard.seeEnemy();
        guard.printState();

        
        guard.loseTarget();
        guard.printState();

        
        guard.hearNoise();
        guard.printState();

        System.out.println("=== Idle Tests ===");

        SentinelGuard idleGuard = new SentinelGuard();
        idleGuard.printState();

        
        idleGuard.loseTarget();
        idleGuard.printState();

       
        idleGuard.hearNoise();
        idleGuard.printState();

        
        idleGuard.loseTarget();
        idleGuard.printState();

        System.out.println("=== Attacking Tests ===");

        SentinelGuard enemyGuard = new SentinelGuard();

        
        enemyGuard.seeEnemy();
        enemyGuard.printState();

       
        enemyGuard.hearNoise();
        enemyGuard.printState();

        enemyGuard.seeEnemy();
        enemyGuard.printState();

        
        enemyGuard.loseTarget();
        enemyGuard.printState();
    }
}
