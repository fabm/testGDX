package com.neet.blockbunny.handlers;

import java.util.Stack;

import com.neet.blockbunny.main.Game;
import com.neet.blockbunny.states.GameState;
import com.neet.blockbunny.states.LevelSelect;
import com.neet.blockbunny.states.Menu;
import com.neet.blockbunny.states.Play;
import com.neet.blockbunny.states.State;

public class GameStateManager {
	
	private Game game;
	
	private Stack<GameState> gameStates;
	
	public GameStateManager(Game game) {
		this.game = game;
		gameStates = new Stack<GameState>();
		pushState(State.MENU);
	}
	
	public void update(float dt) {
		gameStates.peek().update(dt);
	}
	
	public void render() {
		gameStates.peek().render();
	}
	
	public Game game() { return game; }
	
	private GameState getState(State state) {
		if(state == State.MENU) return new Menu(this);
		if(state == State.PLAY) return new Play(this);
		if(state == State.LEVEL_SELECT) return new LevelSelect(this);
		return null;
	}
	
	public void setState(State state) {
		popState();
		pushState(state);
	}
	
	public void pushState(State state) {
		gameStates.push(getState(state));
	}
	
	public void popState() {
		GameState g = gameStates.pop();
		g.dispose();
	}
	
}