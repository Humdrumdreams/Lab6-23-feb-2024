����   > Z  snabbköp/KassaKö  java/lang/Object kö Ljava/util/List; 	Signature 5Ljava/util/List<Lsnabbköp/händelser/övrigt/Kund;>; <init> ()V Code
   	 
  java/util/ArrayList
  	     LineNumberTable LocalVariableTable this Lsnabbköp/KassaKö; läggTillIKö &(Lsnabbköp/händelser/övrigt/Kund;)V    java/util/List   add (Ljava/lang/Object;)Z	   " ! java/lang/System # $ out Ljava/io/PrintStream;
 & ( ' java/io/PrintStream ) * println (Ljava/lang/Object;)V kund #Lsnabbköp/händelser/övrigt/Kund; taNästaFrånKö %()Lsnabbköp/händelser/övrigt/Kund;  0 1 2 isEmpty ()Z  4 5 6 remove (I)Ljava/lang/Object; 8 !snabbköp/händelser/övrigt/Kund StackMapTable 
köStorlek ()I  = > ; size toString ()Ljava/lang/String; B java/lang/StringBuilder
 A  E Kassakö: [
 A G H I append -(Ljava/lang/String;)Ljava/lang/StringBuilder;  K L 6 get
  N ? @ P ,  R ]
 A N sb Ljava/lang/StringBuilder; i I 
SourceFile KassaKö.java !                 	 
     B     *� *� Y� � �             	                      R     *� +�  W� *� � %�                               + ,   - .     U     *� � / � � *� � 3 � 7�                        9    L 7  1 2     4     
*� � / �                   
      : ;     4     
*� � < �                   
      ? @     �     [� AY� CL+D� FW=� 1+*� � J � 7� M� FW*� � < d� 
+O� FW�*� � < ���+Q� FW+� S�       & 	   !  "  #  $ ) % 8 & ? # O ) V *         [      S T U   > V W  9    �  A*  X    Y