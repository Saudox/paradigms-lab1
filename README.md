# CSE-225 — Programming Languages Paradigms — Lab 1

Building a small Domain Specific Language (DSL) across three paradigms.

## Phase 1 — Flex / Bison
A working calculator language that tokenizes and parses arithmetic expressions,
supporting operator precedence, associativity, parentheses, and error handling.

## Phase 2 — Java AST
The same calculator reimplemented in Java using an Abstract Syntax Tree.
Expressions are parsed with recursive descent and represented as objects
that can evaluate themselves and print as an ASCII tree.

## Phase 3 — Functional Transformation
The AST is transformed into Lisp-style prefix notation and evaluated
recursively with no global mutable state.
