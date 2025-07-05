package bowling

import (
	"github.com/knands42/algs/kata/bowling/gameiface"
	"github.com/knands42/algs/kata/bowling/score_cor"
)

const NUM_OF_PINS = 10

// Ensure BowlingGame implements gameiface.Game
var _ gameiface.Game = (*BowlingGame)(nil)

type BowlingGame struct {
	pins  int
	score int

	roll int

	strike bool
	spare  bool

	scoreHandler score_cor.RollHandler
}

func NewBowlingGame() *BowlingGame {
	strikeHandler := &score_cor.StrikeHandler{}
	spareHandler := &score_cor.SpareHandler{}
	commonHandler := &score_cor.CommonHandler{}

	strikeHandler.SetNext(spareHandler)
	spareHandler.SetNext(commonHandler)

	return &BowlingGame{
		pins:  NUM_OF_PINS,
		score: 0,

		roll: 0,

		spare:  false,
		strike: false,

		scoreHandler: strikeHandler,
	}
}

func (b *BowlingGame) Roll(pinsTakeDown int) {
	if isFinished, _ := b.GameResult(); isFinished {
		return
	}

	b.scoreHandler.Handle(b, pinsTakeDown)

	b.pins -= pinsTakeDown
	b.roll += 1
}

func (b *BowlingGame) SetStrike() {
	b.strike = true
}

func (b *BowlingGame) SetSpare() {
	b.spare = true
}

func (b *BowlingGame) SetScore(score int) {
	b.score = score
}

func (b *BowlingGame) DidItStrike() bool {
	return b.strike
}

func (b *BowlingGame) DidItSpare() bool {
	return b.spare
}

func (b *BowlingGame) Score() int {
	return b.score
}

func (b *BowlingGame) CurrentRoll() int {
	return b.roll
}

func (b *BowlingGame) RemainingPins() int {
	return b.pins
}

func (b *BowlingGame) GameResult() (bool, int) {
	return b.strike || b.CurrentRoll() == 2, b.score
}
