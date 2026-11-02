
## Phase 1
The manual version uses one switch with three cases and one if/else.
Adding another state would require reviewing all three trigger methods.
The hearNoise method would need another case, and the other methods
might need changes depending on the new state's behavior.

## Phase 2
SentinelGuard is the context. It stores the current state and delegates
actions to that state object. Each state class controls its own behavior
and transitions. This keeps the guard from needing repeated conditionals.

## Phase 3
SleepingState adds new behavior without changing IdleState,
PatrollingState, or AttackingState. The main method sets the starting
state to Sleeping. This demonstrates the Open/Closed Principle because
the system gains behavior through a new class while existing state
logic stays unchanged.

## Phase 4
The State Pattern is more extensible because each state's behavior is
in a separate class. The manual version is shorter, but adding states
requires editing conditional logic. The State Pattern has more classes,
but each class is easier to focus on and understand.
