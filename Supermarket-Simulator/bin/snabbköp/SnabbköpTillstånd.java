����   > �  snabbköp/SnabbköpTillstånd  generellSim/SimState tidBeräkningar Lsnabbköp/TimeCalculations; kundIDRäknare I antalLedigaKassor totalTidLedigaKassor totalTidIKassaKö totaltAntalKunderSomKöat $totaltAntalKunderSomFörsöktHandlat antalKunderISnabbköpet totaltAntalBetaldaKunder totaltAntalMissadeKunder antalKunderSomKöar ärSnabbköpÖppet Z kassaKö Lsnabbköp/KassaKö; maxAntalKassor maxAntalKunder ankomstRate D frö J minKassaTid maxKassaTid minPlockTid maxPlockTid tidenSnabbköpetStänger <init> (IIDJDDDDD)V Code
  % ! & ()V	  (  	  * 	 	  ,  	  .  	  0  	  2  	  4  	  6  	  8   : snabbköp/TimeCalculations
 9 < ! = 	(DJDDDD)V	  ?  	  A  	  C   E snabbköp/KassaKö
 D %	  H  	  J    LineNumberTable LocalVariableTable this Lsnabbköp/SnabbköpTillstånd; antalKassor ökaKundIDRäknare ()I getKassaKö ()Lsnabbköp/KassaKö; getTotaltAntalMissadeKunder	  V   getMaxAntalKassor getAntalLedigaKassor ökaAntalLedigaKassor minskaAntalLedigaKassor getTotalTidLedigaKassor	  ] 
  getAnkomstRate ()D getMinKassaTid getMaxKassaTid getMinPlockTid getMaxPlockTid getFrö ()J getTotaltAntalBetaldaKunder	  h   ökaTotaltAntalBetaldaKunder 'getTotaltAntalKunderSomFörsöktHandlat	  l   (ökaTotaltAntalKunderSomFörsöktHandlat getAntalKunderISnabbköpet ökaAntalKunderISnabbköpet minskaAntalKunderISnabbköpet getMaxAntalKunder läggTillMissadKund getTotaltAntalKunderSomKöat	  u   getTotalTidIKassaKö	  x   getAntalKunderSomKöar	  {   ökaAntalKunderSomKöar minskaAntalKunderSomKöar getGenomsnittligLedigKassatid
  � � _ getTime totalTidÖppen getGenomsnittligKöTid StackMapTable getAndelTidLedigaKassor totalMöjligKassaTid getNästaAnkomstTid (D)D
 9 � � � calculateAnkomst nuvarandeTid getNästaPlockTid
 9 � � � calculatePlock getNästaBetalningsTid
 9 � � � calculateBetalnings simulationRunning ()Z
  � � � startSimulation
  � � & stopSimulation
  � � & stängSnabbköp	  �   öppnaSnabbköp
  �
  � � & 
setChanged � Snabbköpet är öppet
  � � � notifyObservers (Ljava/lang/Object;)V getTidentSnabbköpetStänger 
SourceFile SnabbköpTillstånd.java !                 	     
                                                                                               *  ! "  #  (     h*� $*� '*� )*� +*)� -*� /*� 1*	� 3*� 5*� 7*� 9Y)	� ;� >*� @*� B*� DY� F� G*� I�    K   B    1   	 6  7  8  9  : $ ; * < 0 = 6 > L ? Q @ V A a B g E L   f 
   h M N     h O     h      h      h      h      h   	   h      h      h      P Q  #   6     *Y� @`Z� @�    K       K L        M N    R S  #   /     *� G�    K       O L        M N    T Q  #   /     *� U�    K       U L        M N    W Q  #   /     *� B�    K       \ L        M N    X Q  #   /     *� )�    K       _ L        M N    Y &  #   9     *Y� )`� )�    K   
    b 
 c L        M N    Z &  #   9     *Y� )d� )�    K   
    f 
 h L        M N    [ Q  #   /     *� \�    K       j L        M N    ^ _  #   /     *� -�    K       q L        M N    ` _  #   /     *� 1�    K       t L        M N    a _  #   /     *� 3�    K       w L        M N    b _  #   /     *� 5�    K       z L        M N    c _  #   /     *� 7�    K       } L        M N    d e  #   /     *� /�    K       � L        M N    f Q  #   /     *� g�    K       � L        M N    i &  #   9     *Y� g`� g�    K   
    � 
 � L        M N    j Q  #   /     *� k�    K       � L        M N    m Q  #   6     *Y� kZ`� k�    K       � L        M N    n Q  #   /     *� '�    K       � L        M N    o &  #   9     *Y� '`� '�    K   
    � 
 � L        M N    p &  #   9     *Y� 'd� '�    K   
    � 
 � L        M N    q Q  #   /     *� +�    K       � L        M N    r &  #   9     *Y� U`� U�    K   
    � 
 � L        M N    s Q  #   /     *� t�    K       � L        M N    v Q  #   /     *� w�    K       � L        M N    y Q  #   /     *� z�    K       � L        M N    | &  #   9     *Y� z`� z�    K   
    � 
 � L        M N    } &  #   9     *Y� zd� z�    K   
    � 
 � L        M N    ~ _  #   K     *� H*� \�'*� B�ko�    K   
    �  � L        M N     �    � _  #   P     *� t� *� w�*� t�o��    K       �  �  � L        M N   �      � _  #   [     *� H'*� B�kJ*� \�)o�    K       �  �  � L         M N     �     �    � �  #   =     	*� >'� ��    K       � L       	 M N     	 �    � �  #   =     	*� >'� ��    K       � L       	 M N     	 �    � �  #   =     	*� >'� ��    K       � L       	 M N     	 �    � �  #   /     *� ��    K       � L        M N    � &  #   3     *� ��    K   
    �  � L        M N    � &  #   3     *� ��    K   
    �  � L        M N    � &  #   4     *� ��    K   
    �  � L        M N    � &  #   N     *� �*� �*� �*�� ��    K       �  � 	 �  �  � L        M N     �  #   /     *� ��    K        L        M N    � _  #   /     *� I�    K       L        M N    �    �