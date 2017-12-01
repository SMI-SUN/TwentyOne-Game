package com.lmig.gfc.TwentyOne.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.TwentyOne.models.AceCard;
import com.lmig.gfc.TwentyOne.models.Hand;
import com.lmig.gfc.TwentyOne.models.NumberCard;
import com.lmig.gfc.TwentyOne.models.Suits;
import com.lmig.gfc.TwentyOne.models.FaceCard;
import com.lmig.gfc.TwentyOne.models.Faces;
import com.lmig.gfc.TwentyOne.models.Game;

@Controller

public class TwentyOneController {

	private Game game;

	public TwentyOneController() {
		game = new Game();
	}

	@RequestMapping("/")
	public ModelAndView showForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bet");
		mv.addObject("game", game);
		return mv;
	}

	@PostMapping("/bet")
	public ModelAndView handleBet(int bet) {
		game.makePlayerBet(bet);
		game.setUpGame();
		ModelAndView mv = new ModelAndView();
		mv.addObject("game", game);
		mv.setViewName("redirect:/play");
		return mv;
	}

	@GetMapping("/play")
	public ModelAndView showPlayScreen() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("play");
		
		// mv.addObject("UserplayerHand", game.getPlayerHand());
		mv.addObject("game", game);
		
		return mv;
	}
	
	@PostMapping("/hit")
	public ModelAndView hitPlayScreen() {
		ModelAndView mv = new ModelAndView();
		try {
			game.hitPlayer();
			if (game.didPlayerLose()) {
				game.payout();
			}
			mv.setViewName("redirect:/play");
		} catch(Exception e) {
			mv.setViewName("redirect:/over");
		}
		return mv;
	} 
	
	@PostMapping("/stand")
	public ModelAndView standPlayScreen() {
		ModelAndView mv = new ModelAndView();
		try {
			game.hitDealerUntilDone();
			game.payout();
		} catch(Exception e) {
			
		}
		
		mv.setViewName("redirect:/over");
		return mv;
	}
	
	
	@GetMapping("/over")
	public ModelAndView overPlayScreen() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("game", game);
		mv.setViewName("over");
		return mv;
	}
	
	
	
	
	@PostMapping("/reBet")
	public ModelAndView nextHandScreen(int bet) {
		ModelAndView mv = new ModelAndView();
		game.makePlayerBet(bet);
		game.resetGame();
	//	game.payout();
		// if game.playerWon()
			// mv.setViewName(playerWON)
			// else { mv.setViewName(playerLost)

		mv.setViewName("redirect:/play");
		return mv;
	}
	
}
