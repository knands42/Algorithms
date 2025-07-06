package calculator

import (
	"fmt"
	"regexp"
	"strconv"
	"strings"
	"unicode"
)

func Calculate(expr string) float64 {
	if expr == "" {
		return 0
	}

	for {
		if strings.Contains(expr, "(") {
			expr = evalInnermostParentheses(expr)
		} else {
			break
		}
	}

	tokens := tokenize(expr)
	return calculateExpression(tokens)
}

func evalInnermostParentheses(expr string) string {
	re := regexp.MustCompile(`\([^()]+\)`)
	match := re.FindString(expr)

	if match == "" {
		return expr
	}

	innerExpr := match[1 : len(match)-1]
	tokens := tokenize(innerExpr)
	value := calculateExpression(tokens)

	return strings.Replace(expr, match, fmt.Sprintf("%f", value), 1)
}

func calculateExpression(numbersExpr []string) float64 {
	onlyAddAndSubExpr := evalDivAndMultiplication(numbersExpr)
	return evalSumAndMultiplication(onlyAddAndSubExpr)
}

func tokenize(expr string) []string {
	tokens := make([]string, 0)
	nums := strings.Builder{}

	for _, ch := range expr {
		if unicode.IsDigit(ch) || ch == '.' {
			nums.WriteRune(ch)
		} else {
			if nums.Len() > 0 {
				tokens = append(tokens, nums.String())
				nums.Reset()
			}

			tokens = append(tokens, string(ch))
		}
	}

	if nums.Len() > 0 {
		tokens = append(tokens, nums.String())
	}

	return tokens
}

func evalDivAndMultiplication(tokens []string) []string {
	var result []string
	i := 0

	for i < len(tokens) {
		token := tokens[i]

		if token == "*" || token == "/" {
			leftVal, _ := strconv.ParseFloat(tokens[i-1], 64)
			rightVal, _ := strconv.ParseFloat(tokens[i+1], 64)

			var computed float64
			if token == "*" {
				computed = leftVal * rightVal
			} else {
				computed = leftVal / rightVal
			}

			result[len(result)-1] = fmt.Sprintf("%f", computed)
			i += 2
		} else {
			result = append(result, token)
			i++
		}
	}

	return result
}

func evalSumAndMultiplication(tokens []string) float64 {
	result, _ := strconv.ParseFloat(tokens[0], 64)

	for i := 1; i < len(tokens); i += 2 {
		operation := tokens[i]
		right, _ := strconv.ParseFloat(tokens[i+1], 64)

		switch operation {
		case "+":
			result += right
		case "-":
			result -= right
		}
	}

	return result
}
