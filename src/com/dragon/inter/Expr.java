package com.dragon.inter;

import com.dragon.lexer.Token;
import com.dragon.symbols.Type;

public class Expr extends Node{
	public Token opToken;
	public Type type;
	Expr(Token opToken, Type type) {
		this.opToken = opToken;
		this.type = type;
	}
	
	public Expr gen() {
		return this;
	}
	
	public Expr reduce() {
		return this;
	}
	
	public void jumping(int t, int f) {
		emitJumps(toString(), t, f);
	}
	
	public void emitJumps(String test, int t, int f) {
		if (t != 0 && f != 0 ) {
			emit("if " + test + " goto L" + t);
			emit("goto L" + f);
		} else if (t != 0) {
			emit("if " + test + "goto L" + t);
		} else if (f != 0) {
			emit("iffalse " + test  + "goto L" + f);
		} else;
	}
	
	@Override
	public String toString() {
		return opToken.toString();
	}
	
}
