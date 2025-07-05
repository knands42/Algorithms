package score_cor

import "github.com/knands42/algs/kata/bowling/gameiface"

const NUM_OF_PINS = 10

type BaseHandler struct {
	next RollHandler
}

func (handler *BaseHandler) SetNext(roll RollHandler) {
	handler.next = roll
}

func (handler *BaseHandler) CallNext(game gameiface.Game, pins int) {
	if handler.next != nil {
		handler.next.Handle(game, pins)
	}
}
