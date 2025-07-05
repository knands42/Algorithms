package score_cor

import (
	"math"

	"github.com/knands42/algs/kata/bowling/gameiface"
)

type SpareHandler struct {
	BaseHandler
}

func (handler *SpareHandler) Handle(game gameiface.Game, pinsTakeDown int) {
	pinsRemaining := game.RemainingPins() - int(math.Abs(float64(pinsTakeDown)))

	if game.CurrentRoll() == 1 && pinsRemaining == 0 {
		game.SetScore(NUM_OF_PINS + game.RemainingPins())
		game.SetSpare()
	} else {
		handler.CallNext(game, pinsTakeDown)
	}
}
