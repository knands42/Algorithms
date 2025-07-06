package calculator

import (
	"github.com/knands42/algs/kata/calculator"
	. "github.com/onsi/ginkgo/v2"
	. "github.com/onsi/gomega"
)

var _ = Describe("Calculator", func() {

	Describe("Multiplication", func() {
		It("should return 0 if empty string is provided", func() {
			// given

			// when
			result := calculator.Calculate("")

			// then
			Expect(result).To(Equal(float64(0)))
		})

		It("should calculate simple multiplication", func() {
			// given

			// when
			result := calculator.Calculate("8*9")

			// then
			Expect(result).To(Equal(float64(72)))
		})

		It("should calculate simple multiplication with one group", func() {
			// given

			// when
			result := calculator.Calculate("(8*9)")

			// then
			Expect(result).To(Equal(float64(72)))
		})

		It("should calculate a multiplication with inner and outer operation", func() {
			// given

			// when
			result := calculator.Calculate("2*(8*9)")

			// then
			Expect(result).To(Equal(float64(144)))
		})
	})

	Describe("Mix operations", func() {
		It("should calculate a mix of multiplication and add operation with one group", func() {
			// given

			// when
			result := calculator.Calculate("2+(4*(1+2)-(3*4))")

			// then
			Expect(result).To(Equal(float64(2)))
		})
	})
})
