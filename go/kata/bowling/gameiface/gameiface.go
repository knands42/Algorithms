package gameiface

// Game defines the interface that the score handlers expect
type Game interface {
	SetStrike()
	SetSpare()
	SetScore(score int)
	DidItStrike() bool
	DidItSpare() bool
	Score() int
	CurrentRoll() int
	RemainingPins() int
}
