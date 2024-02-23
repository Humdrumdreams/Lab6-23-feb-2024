����   > V  generellSim/EventQueue  java/lang/Object 
eventQueue Ljava/util/ArrayList; 	Signature *Ljava/util/ArrayList<LgenerellSim/Event;>; <init> ()V Code
   	 
  java/util/ArrayList
  	     LineNumberTable LocalVariableTable this LgenerellSim/EventQueue; addEvent (LgenerellSim/Event;)Z
    generellSim/Event   hasEventHappened ()Z
    ! " add (Ljava/lang/Object;)Z   $ % & applyAsDouble '()Ljava/util/function/ToDoubleFunction; ( * ) java/util/Comparator + , comparingDouble =(Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
  . / 0 sort (Ljava/util/Comparator;)V e LgenerellSim/Event; StackMapTable getNextEvent ()LgenerellSim/Event;
  7 8  isEmpty
  : ; < remove (I)Ljava/lang/Object; 
SourceFile EventQueue.java BootstrapMethods
 A C B "java/lang/invoke/LambdaMetafactory D E metafactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; @ (Ljava/lang/Object;)D G
  J K L getTimeOfEvent ()D I (LgenerellSim/Event;)D N InnerClasses R %java/lang/invoke/MethodHandles$Lookup T java/lang/invoke/MethodHandles Lookup !                 	 
     B     *� *� Y� � �                                   p     #+� � *� +� W*� � #  � '� -��                !  " ! $        #       # 1 2  3    !  4 5     S     *� � 6� *� � 9� ��           - 
 .  0             3      8      2     *� � 6�           9              =    > ?     F  H M O P   
  Q S U 