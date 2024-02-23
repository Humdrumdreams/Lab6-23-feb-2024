����   > �  snabbköp/SnabbköpVy  generellSim/SimView 
tillstånd Lsnabbköp/SnabbköpTillstånd; <init> "(Lsnabbköp/SnabbköpTillstånd;)V Code
     ()V	     LineNumberTable LocalVariableTable this Lsnabbköp/SnabbköpVy; update +(Ljava/util/Observable;Ljava/lang/Object;)V  generellSim/Event  #snabbköp/händelser/Starthändelse
     visaParametrar  "snabbköp/händelser/Stophändelse
      visaResultat o Ljava/util/Observable; arg Ljava/lang/Object; event LgenerellSim/Event; StackMapTable visaRubriker	 * , + java/lang/System - . out Ljava/io/PrintStream; 0 P	Tid 	Händelse 	Kund 	? 	led 	ledT 	I 	$ 	:-( 	köat 	köT 	köar 	[Kassakö..]
 2 4 3 java/io/PrintStream 5 6 println (Ljava/lang/String;)V 8 �PARAMETRAR
==========
Antal kassor, N..........: %d
Max som ryms, M..........: %d
Ankomshastighet, lambda..: %.2f
Plocktider, [P_min..Pmax]: [%.2f..%.2f]
Betaltider, [K_min..Kmax]: [%.2f..%.2f]
Frö, f...................: %d
FÖRLOPP
======= : java/lang/Object
 < > = snabbköp/SnabbköpTillstånd ? @ getMaxAntalKassor ()I
 B D C java/lang/Integer E F valueOf (I)Ljava/lang/Integer;
 < H I @ getMaxAntalKunder
 < K L M getAnkomstRate ()D
 O Q P java/lang/Double E R (D)Ljava/lang/Double;
 < T U M getMinPlockTid
 < W X M getMaxPlockTid
 < Z [ M getMinKassaTid
 < ] ^ M getMaxKassaTid
 < ` a b getFrö ()J
 d f e java/lang/Long E g (J)Ljava/lang/Long;
 i k j java/lang/String l m format 9(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String; o)Resultat
========
1) Av %d kunder handlade %d medan %d missades.
2) Total tid %d kassor varit lediga: %.2f te.
   Genomsnittlig ledig kassatid: %.2f te (dvs %.2f%% av tiden från öppning tills sista kunden betalat).
3) Total tid %d kunder tvingats köa: %.2f te.
   Genomsnittlig kötid: %.2f te.
 < q r @ 'getTotaltAntalKunderSomFörsöktHandlat
 < t u @ getTotaltAntalBetaldaKunder
 < w x @ getTotaltAntalMissadeKunder
 < z { @ getTotalTidLedigaKassor
 < } ~ M getGenomsnittligLedigKassatid
 < � � M getAndelTidLedigaKassor
 < � � @ getTotaltAntalKunderSomKöat
 < � � @ getTotalTidIKassaKö
 < � � M getGenomsnittligKöTid 
SourceFile SnabbköpVy.java !                	   F     
*� 
*+� �              	         
       
        	   �     ,� N-� � *� -� � *� �                 #  $  &    *            ! "     # $    % &  '   	 �  
  (   	   7     	� )/� 1�       
    *  +        	         	   �     {� )7� 9Y*� � ;� ASY*� � G� ASY*� � J� NSY*� � S� NSY*� � V� NSY*� � Y� NSY*� � \� NSY*� � _� cS� h� 1�       .    /  :  ; & < 3 = @ > M ? [ @ i A t / z C        {          	   �     �� )n
� 9Y*� � p� ASY*� � s� ASY*� � v� ASY*� � ;� ASY*� � y� ASY*� � |� NSY*� � � NSY*� � �� ASY*� � �� ASY	*� � �� NS� h� 1�       6    ]  f  g & h 3 i @ j M k [ l i m w n � o � ] � q        �      �    �