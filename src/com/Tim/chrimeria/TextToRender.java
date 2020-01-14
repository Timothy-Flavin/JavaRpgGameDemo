package com.Tim.chrimeria;

public class TextToRender {
	public static int numDialogues = 10;
	private String[] text;
	private String name;
	
	
	private static String introName = "intro";
	private static String[] intro = new String[]{
	new String("(cuchulain) what should i do leag? am i the only one left to defend ulster? if only macha had not been forced to race, we wouldn't be under this curse."),
	new String("(laeg) perhaps you should defend ulster from maeve's forces on your own, after all you can fight them in small groups here at the ford bottleneck. most of them are just regular soldiers, no problem for you."),
	new String("(cuchulain) so long as you patch me up, but i am worried that in her quest to steal the brown bull, meave will find a champion to challenge me. at least i should be safe from ferdia, he would never fight me for her. we are too close to being brothers after our training at scathach."),
	new String("(laeg) you should rest in your bed. you have a long few days ahead. use w a s d or the arrow keys to move and e to activate interactable objects. we can always come back and heal at your bed but there could be useful tools on the way down to the ford."),
	new String("(cuchulain) do you remember where i last left my legendary spear, the gea bolga?"),
	new String("(laeg) it was in your outpost near the bottom of the cliff last i remember. perhaps we will find more other gear on the way down to the bottom."),
	new String("(cuchulain) let us head out then."),
	new String("(laeg) one final warning, maeve's forces may try to ambush us. avoid the dark grass where they could be hiding.")};
	
	private static String healName = "heal";
	private static String[] heal = new String[]{
	new String("you rest for the night and your health is restored.")};
	
	private static String healAltName = "healAlt";
	private static String[] healAlt = new String[]{
	new String("already full health.")};
	
	private static String newsName = "news";
	private static String[] news = new String[]{
	new String("(laeg) the legendary warriors of the red branch are incapacitated by macha's curse, but the curse should be lifeted in a few days. if you can hold the ford until then ulster should be safe."),
	new String("(laeg) due to your killing of maeve's troups, she will likely reach out for a champion to settle the matter. the bottom of the ford has a wattery path that we can use to fight one at a time."),
	new String("(cuchulain) thank you laeg, you are a good allie to have. i can't bear the thought of fighting ferdia if maeve tries to enlist him. we are blood brothers.")};
	//new String("you are cuchulainn at the ford waiting to challenge the forces of maeve and eventually ferdia. your house can be used to heal after battles")};
	
	private static String item1Name = "item1";
	private static String[] item1 = new String[]{
	new String("you found a skill book, focus"),
	new String("(laeg) looks like you've found one of the tuatha de danann's instruction books. it describes a way to focus your mind and attack with more potency."),
	new String("(cuchulain) do you think this will give me the edge against maeve's champion? i wonder if finn ever left instructions such as this.")};
	
	private static String item2Name = "item2";
	private static String[] item2 = new String[]{
	new String("you found a hide helmet"),
	new String("(laeg) a helmet might do you some good in the battles to come."),
	new String("(cuchulain) armor is only a hindrance in combat."),
	new String("(laeg) chest armor may be, but a helmet just might give you an edge."),
	new String("(cuchulain) you are right."), 
	};
	
	private static String item3Name = "item3";
	private static String[] item3 = new String[]{
	new String("you found bandages"),
	new String("(laeg) i will be able to use these to heal you more easily"),
	new String("(cuchulain) good, we may want to rest soon.")};
	
	private static String item4Name = "item4";
	private static String[] item4 = new String[]{
	new String("you found food"),
	new String("(laeg) this will restore us. (restored to full health)"),
	};
	
	private static String item5Name = "item5";
	private static String[] item5 = new String[]{
	new String("a letter. it reads "),
	new String("will you come to feast with me tomorrow? i have much to offer you, ferdia mac daman, and in return i only want your service. my daughter beautiful finnavir would like to see you and if all goes well you may have her hand in marriage."),
	new String("you may also recieve vast herds without tax. if this intrigues you, join me at my feast tomorrow and we may talk about the terms of your contract. a certain hound is causing problems... maeve."),
	new String("(cuchulain) you don't think he will agree to it do you laeg?"),
	new String("(laeg) i can not be sure, but we must be on out guard. perhaps this injustice may bring about your battle rage, but we must retrieve the gae bolga to be sure of victory."),
	};
	
	private static String item6Name = "item6";
	private static String[] item6 = new String[]{
	new String("you find the gae bolga. it will hit weak points and split into pieces and destroy anyone it pierces."), 
	new String("(laeg) at last, with this you should be able to defeat ferdia. perhaps we should heal again first to be safe."),
	new String("(cuhulain) i hope not to have to use it... ferdia. why have you sided with maeve?")
	};
	
	private static String expositionName = "exposition";
	private static String[] exposition = new String[]{
		new String("how well do you know the story of macha which plagues us?"),
		new String("(cuchulain) i have only heard rumors of it's origin. what happened?"),
		new String("(laeg) a poor farmer named crunden's wife died and his house was in dissaray when one day he came home to a clean house and a woman named macha who said she was to become his wife. he accepted, thankful for his good fortune."),
		new String("(laeg) king conner summoned him to a feast but macha warned him that if he were to boast about her that iw would bring ruin upon them. he ended up bragging to connor that his wife could beat conor's horses in a race and so macha had to race them."),
		new String("(cuchulain) what does this have to do with the curse?"),
		new String("(laeg) patience. she was due to birth twins, and while macha won the race, she was forced to give birth at the end to two stillborn children and she placed a curse on ulster that in a time of need all the men would feel birthing pains."),
	};
	
	private static String endName = "end";
	private static String[] end = new String[]{
		new String("(laeg) he shall die. let me wash the gae boldga. (rips gae bolga from ferdia's body)"),
		new String("(cuchulain) how could you side with her?"),
		new String("(ferdia) she claimed that i was the weaker one of us. i had to fight for my honor, i am sorry it has come to this cuchulain."),
		new String("(they cry)"),
		new String("(cuchulain) let me carry you back to ulster so that you do not have to die in the land of maeve and her treachery. come with me."),
		new String("the end, game will quit now"),
	};
	
	private static TextToRender[] dialogueLists = new TextToRender[]{
		new TextToRender(intro, introName),
		new TextToRender(heal, healName),
		new TextToRender(healAlt, healAltName),
		new TextToRender(news, newsName),
		new TextToRender(item1, item1Name),
		new TextToRender(item2, item2Name),
		new TextToRender(item3, item3Name),
		new TextToRender(item4, item4Name),
		new TextToRender(item5, item5Name),
		new TextToRender(item6, item6Name),
		new TextToRender(exposition, expositionName),
		new TextToRender(end, endName),
		};
	
	private static String[] dialogueNames = new String[]{
		dialogueLists[0].getName(),
		dialogueLists[1].getName(),
		dialogueLists[2].getName(),
		dialogueLists[3].getName(),
		dialogueLists[4].getName(),
		dialogueLists[5].getName(),
		dialogueLists[6].getName(),
		dialogueLists[7].getName(),
		dialogueLists[8].getName(),
		dialogueLists[9].getName(),
		dialogueLists[10].getName(),
		dialogueLists[11].getName(),
		};
	
	//intro[0]="Use W-A-S-D keys to move";
	//dialogueList[0]= new TextToRender()
	
	public TextToRender(String[] text, String name){
		this.text = text;
		this.name = name;
	}
	
	public static TextToRender getDialogueByName(String name){
		for(int i = 0; i < dialogueNames.length;i++){
			if(name.equals(dialogueNames[i])){
				return dialogueLists[i];
			}
		}
		return null;
	}
	public String getName(){
		return name;
	}
	public String[] getTextArray(){
		return text;
	}
}
