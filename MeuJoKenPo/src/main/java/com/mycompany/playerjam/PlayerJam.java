/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.playerjam;

import io.github.guisso.jankenpon.AbstractPlayer;
import io.github.guisso.jankenpon.Move;
import java.util.Random;

/**
 *
 * @author TodoMundo
 */
public class PlayerJam extends AbstractPlayer {
    
    Move[] moves = {Move.ROCK,Move.PAPER,Move.SCISSORS};
    
    
     int myLastMove;
    
     private int FindMoveIndex(Move move){
     
        for(int i = 0;;i++){

        if(move == moves[i]){return i;}
        }
        
     }
  
    @Override
    public String getDeveloperName() {
        return "Nicolas Marques da Silva";
    }

    @Override
    public Move makeMyMove(Move opponentPreviousMove) {
        
        if(opponentPreviousMove == Move.NONE){
            
            Random rnd = new Random();
            myLastMove = rnd.nextInt(3); 
            return moves[myLastMove];
            
        }
        
        //Caso de Empate
           if(opponentPreviousMove == moves[myLastMove]){
           
                myLastMove = myLastMove == 0? 2 : myLastMove-1 ;
                return moves[myLastMove];
               
           }
           
       //Caso de Derrota
         if( myLastMove != 2){
         
         if( myLastMove < FindMoveIndex(opponentPreviousMove) ){
         
        myLastMove = FindMoveIndex(opponentPreviousMove);
        return moves[myLastMove];
         
         }else if(opponentPreviousMove == Move.ROCK){
         
             myLastMove = FindMoveIndex(opponentPreviousMove);
             return moves[myLastMove];
         
         }
         
         }
           
         
           //Caso de vitoria
            return moves[myLastMove];
              }
    
            
}
