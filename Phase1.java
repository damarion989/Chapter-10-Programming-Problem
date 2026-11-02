class ManualSentinelGuard {
    enum State {
        IDLE, PATROLLING, ATTACKING
    }

    private State currentState = State.IDLE;

    public void hearNoise() {
        switch (currentState) {
            case IDLE:
                currentState = State.PATROLLING;
                System.out.println("Guard heard a noise and is investigating.");
                break;

            case PATROLLING:
                System.out.println("Guard is already on alert.");
                break;

            case ATTACKING:
                System.out.println("Guard is too busy fighting to notice the noise.");
                break;
        }
    }

    public void seeEnemy() {
        currentState = State.ATTACKING;
        System.out.println("Guard spotted the enemy and is attacking.");
    }

    public void loseTarget() {
        if (currentState == State.ATTACKING) {
            currentState = State.PATROLLING;
            System.out.println("Guard is searching for the escaped enemy.");
        } else {
            System.out.println("No target to lose.");
        }
    }

    public void printState() {
        System.out.println("Current state: " + currentState);
        System.out.println();
    }
}

public class Phase1 {
    public static void main(String[] args) {
        ManualSentinelGuard guard = new ManualSentinelGuard();

        guard.printState();

        
        guard.loseTarget();
        guard.printState();

        
        guard.hearNoise();
        guard.printState();

        
        guard.hearNoise();
        guard.printState();

        guard.loseTarget();
        guard.printState();

        
        guard.seeEnemy();
        guard.printState();

        
        guard.hearNoise();
        guard.printState();

        guard.seeEnemy();
        guard.printState();

        
        guard.loseTarget();
        guard.printState();

        
        ManualSentinelGuard secondGuard = new ManualSentinelGuard();
        secondGuard.seeEnemy();
        secondGuard.printState();
    }
}
