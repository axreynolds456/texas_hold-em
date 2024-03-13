package players;

import game.HandRanks;
import game.Player;

public class AidanPlayer extends Player {

    boolean hasDecentHand;
    public AidanPlayer(String name) {
        super(name);
    }



    @Override
    protected void takePlayerTurn() {
        if(getGameState().isActiveBet()) {
            if(getGameState().getNumRoundStage() == 0) {
                // i know there is a bet pre-flop
            }
        }
    }

    @Override
    protected boolean shouldFold() {
        if((hasDecentHand = evaluatePlayerHand().getValue() <= HandRanks.PAIR.getValue() && (getGameState().getNumRoundStage() == 2))) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean shouldCheck() {
        return false;
    }

    @Override
    protected boolean shouldCall() {
        return false;
    }

    @Override
    protected boolean shouldRaise() {
        if(hasDecentHand = evaluatePlayerHand().getValue() >= HandRanks.TWO_PAIR.getValue()) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    protected boolean shouldAllIn() {
        return false;
    }
}
