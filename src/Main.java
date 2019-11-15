import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String text="INTRODUCTION \n" +
                "\n" +
                "       This guide is intended to help users of Foreign Broadcast \n" +
                "Information Service (FBIS) translations assess the value and \n" +
                "reliability of media sources in the countries or regions of the \n" +
                "former Yugoslavia.  It provides key information about the media \n" +
                "of Bosnia-Herzegovina, Croatia, The Former Yugoslav Republic of \n" +
                "Macedonia, Slovenia, and the Federal Republic of Yugoslavia \n" +
                "(incorporating Serbia and Montenegro).  Wherever possible, an \n" +
                "at tempt has been made to identify affiliations or reliably \n" +
                "reported connections between media sources and governmental or \n" +
                "communal leadership groups. \n" +
                "\n" +
                "   All media identified in this guide are monitored by FBIS, but \n" +
                "in some cases, due to wartime conditions, receipts have been \n" +
                "irregular and the information provided in the guide may be \n" +
                "incomplete.  Characterizations, where provided, are based on FBIS \n" +
                "analysis of editorial content.  Entries are grouped by region, \n" +
                "and, within regions, by category: publications, radio, \n" +
                "television, and news agencies.  The \"sourcelines\" cited at the \n" +
                "beginning of each entry are the descriptors used by FBIS to \n" +
                "identify media sources of FBIS translations.  Sourcelines are \n" +
                "composed of three elements--the place of origin of the medium, \n" +
                "its name, and the language it uses. \n" +
                "\n" +
                "\n" +
                "   BOSNIA-HERZEGOVINA \n" +
                "\n" +
                "   PUBLICATIONS \n" +
                "\n" +
                "JAVNOST \n" +
                "\n" +
                "Sourceline:              Pale JAVNOST in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     The Public \n" +
                "\n" +
                "Masthead caption:        \"Weekly Information Newspaper of the \n" +
                "                         Republic of Srpska\" \n" +
                "\n" +
                "Type of publication:     Weekly newspaper \n" +
                "\n" +
                "Day of publication:      Saturday \n" +
                "Publisher:               Javnost Newspaper Publishing Enterprise \n" +
                "\n" +
                "Address:                 71000 Pale \n" +
                "\n" +
                "Chief editor:            Jovan Janjic \n" +
                "\n" +
                "Founded by and represents the views of the People's Assembly of \n" +
                "the self-styled Republic of Srpska, led by Radovan Karadzic; \n" +
                "printed in Belgrade by the Politika publishing enterprise. \n" +
                "\n" +
                "   RADIO \n" +
                "\n" +
                "MOSTAR CROATIAN RADIO HERZEG-BOSNA \n" +
                "\n" +
                "Sourceline:              Mostar Croatian Radio Herzeg-Bosna in \n" +
                "                         Serbo-Croatian \n" +
                "\n" +
                "Station identification:  \"This is Croatian Radio Herzeg-Bosna\" \n" +
                "\n" +
                "Monitored by dial-up phone feed; represents the views of the \n" +
                "leadership of the self-proclaimed Croatian Republic of \n" +
                "Herzeg-Bosna in Bosnia-Herzegovina. \n" +
                "\n" +
                "PALE RADIO \n" +
                "\n" +
                "Sourceline:              Pale Srpski Radio-Televizija Studio \n" +
                "                         Sarajevo Radio in Serbo-Croatian \n" +
                "\n" +
                "Station identification:  \"Serb Radio-Television First Program \n" +
                "                         Radio, Studio Sarajevo\" \n" +
                "\n" +
                "Principal frequencies:   1242, 1395 kHz; FM: 88.7, 89.9, 91.7, \n" +
                "                         92.5, 92.8, 101.7, 102.3, 106.2 MHz \n" +
                "Hours of operation:      Newscasts observed at \n" +
                "0600 GMT and 1600 GMT \n" +
                "\n" +
                "Broadcasts from Pale, the administrative center of the \n" +
                "self-proclaimed Serb Republic in Bosnia-Herzegovina.  Employs \n" +
                "mainly former Radio Sarajevo journalists, who fled Sarajevo after \n" +
                "the outbreak of war.  Uses transmitters and relays once used by \n" +
                "Radio Sarajevo, principally on FM and mediumwave frequencies. \n" +
                "Represents the views of the Serb leadership of the \"Republic of \n" +
                "Srpska\" in Bosnia-Herzegovina.  First heard on 27 December 1992. \n" +
                "FBIS does not monitor television from this source. \n" +
                "\n" +
                "SARAJEVO RADIO \n" +
                "\n" +
                "Sourceline:              Sarajevo Radio Bosnia-Herzegovina \n" +
                "                         Network in Serbo-Croatian \n" +
                "\n" +
                "Station identification:  \"Radio Bosnie-Hercegovine\" or \"Radio \n" +
                "                         Bosnie-Hercegovine Studio Sarajevo\" \n" +
                "\n" +
                "Other languages:         English (some newscasts broadcast in \n" +
                "                         English) \n" +
                "\n" +
                "Principal frequencies:   612, 6889.27 kHz upper sideband \n" +
                "\n" +
                "Hours of operation:      0400-2400 GMT Monday-Friday; 24 hours \n" +
                "                         Saturday-Sunday \n" +
                "\n" +
                "Operated by the Bosnian Government, led by President Alija \n" +
                "Izetbegovic; represents the views of the predominantly Muslim \n" +
                "authorities.  At 1900 GMT the radio carries the audio portion of \n" +
                "the main Sarajevo Television newscast.  The station has \n" +
                "experienced frequent outages over the past two years because of \n" +
                "the fighting in and around Sarajevo but has not been off the air \n" +
                "for more than a few days. \n" +
                "\n" +
                "   CROATIA \n" +
                "\n" +
                "   PUBLICATIONS \n" +
                "\n" +
                "BIH EKSKLUZIV \n" +
                "\n" +
                "Sourceline:              Split BIH EKSKLUZIV in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     Bosnia-Herzegovina Exclusive \n" +
                "\n" +
                "Masthead caption:        \"So That You Do Not Forget Your \n" +
                "                         Homeland\" \n" +
                "\n" +
                "Type of publication:     Weekly newspaper \n" +
                "\n" +
                "Day of publication:      Friday \n" +
                "\n" +
                "Publisher:               Una Press \n" +
                "\n" +
                "Address:                 Postanski Pregradak 431, 58000 Split \n" +
                "\n" +
                "Director/Chief editor:   Ahmed Bosnic \n" +
                "\n" +
                "Target readers are Bosnian refugees in Croatia.  Concentrates on \n" +
                "reports of fighting in Bosnia-Herzegovina, crimes allegedly \n" +
                "committed by Serbs, some foreign affairs. \n" +
                "\n" +
                "DANAS \n" +
                "\n" +
                "Sourceline:              Zagreb DANAS in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     Today \n" +
                "\n" +
                "Masthead caption:        \"Croatian Political Weekly\" \n" +
                "\n" +
                "Type of publication:     Weekly magazine \n" +
                "\n" +
                "Day of publication:      Tuesday \n" +
                "\n" +
                "Publisher:               Maximal-Peko \n" +
                "\n" +
                "Address:                 Slavonska Avenija 4, 41000 Zagreb \n" +
                "\n" +
                "Director:                Boris Ivin Peko \n" +
                "\n" +
                "Chief editor:            Hloverka Novak-Srzic \n" +
                "\n" +
                "This magazine, originally a publication of the government-owned \n" +
                "Vjesnik publishing enterprise, changed its name from DANAS to \n" +
                "NOVI DANAS in July 1992 after being privatized.  Publication of \n" +
                "NOVI DANAS was suspended in September 1992, after only eight \n" +
                "issues, some of which were sharply critical of the government. \n" +
                "It reappeared as DANAS on 8 January 1993 under the ownership of a \n" +
                "new private company, led by Director Peko.  Chief editor \n" +
                "Novak-Srzic, a former Zagreb television journalist, has been \n" +
                "described by the Zagreb weekly GLOBUS as a Croation Democratic \n" +
                "Community (HDZ) stalwart.  While generally supportive of the \n" +
                "government, DANAS has occasionally come under attack by some \n" +
                "government figures for articles deemed unfairly critical of the \n" +
                "authorities. \n" +
                "\n" +
                "GLAS SLAVONIJE \n" +
                "\n" +
                "Sourceline:              Osijek GLAS SLAVONIJE in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     Voice of Slavonia \n" +
                "\n" +
                "Masthead caption:        \"The War Edition\" \n" +
                "\n" +
                "Type of publication:     Newspaper \n" +
                "\n" +
                "Days of publication:     Monday-Saturday \n" +
                "\n" +
                "Publisher:               Medija centar \"Glas Slavonije\" \n" +
                "\n" +
                "Address:                 Hrvatske Republike 20, Osijek \n" +
                "\n" +
                "Director:                Karlo Karacic \n" +
                "\n" +
                "Chief editor:            Vladimir Vazdar \n" +
                "\n" +
                "Regional daily that reflects the strongly Croatian nationalist \n" +
                "views of the leadership of Slavonia; also carries foreign news \n" +
                "and commentaries. \n" +
                "\n" +
                "GLASNIK \n" +
                "\n" +
                "Sourceline:              Zagreb GLASNIK in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     The Herald \n" +
                "\n" +
                "Masthead caption:        \"Herald of the Croatian Democratic \n" +
                "                         Community\" \n" +
                "\n" +
                "Type of publication:     Weekly magazine \n" +
                "\n" +
                "Day of publication:      Monday \n" +
                "\n" +
                "Publisher:               Hrvatska Demokratska Zajednica \n" +
                "\n" +
                "Address:                 Trg Hrvatske Velikana 4, Zagreb \n" +
                "\n" +
                "Chief editor:            Zdravko Gavran \n" +
                "\n" +
                "Party weekly with its editorial office located in Croatian \n" +
                "Democratic Community (HDZ) headquarters.  Authoritatively \n" +
                "represents HDZ views, contains reports and commentaries on \n" +
                "domestic and foreign affairs as well as reports on party affairs \n" +
                "and interviews with party figures. \n" +
                "\n" +
                "GLOBUS \n" +
                "\n" +
                "Sourceline:              Zagreb GLOBUS in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     The Globe \n" +
                "\n" +
                "Masthead caption:        \"National Weekly\" \n" +
                "\n" +
                "Type of publication:     Weekly newspaper \n" +
                "\n" +
                "Day of publication:      Friday \n" +
                "\n" +
                "Publisher:               Globus International \n" +
                "\n" +
                "Address:                 Marticeva 22, Zagreb \n" +
                "\n" +
                "Director:                Zdravko Jurak \n" +
                "\n" +
                "Chief editor:            Denis Kuljis \n" +
                "Independent, privately owned newspaper that features interviews, \n" +
                "reports, and articles on domestic and foreign issues.  It is \n" +
                "known for its provocative, sometimes sensationalist style, and \n" +
                "for investigative journalism.  It frequently publishes results of \n" +
                "polls on the popularity of Croatian parties and leaders. \n" +
                "\n" +
                "HRVATSKI VOJNIK \n" +
                "\n" +
                "Sourceline:              Zagreb HRVATSKI VOJNIK in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     Croatian Soldier \n" +
                "\n" +
                "Masthead caption:        \"Gazette of the Croatian Ministry of \n" +
                "                         Defense\" \n" +
                "\n" +
                "Type of publication:     Biweekly magazine \n" +
                "\n" +
                "Day of publication:      1st and 15th of the month \n" +
                "\n" +
                "Publisher:               Croatian Ministry of Defense \n" +
                "\n" +
                "Address:                 Zvonimirova 12, Zagreb \n" +
                "\n" +
                "Chief editor:            Brigadier Ivan Tolj \n" +
                "\n" +
                "Supplement:              HRVATSKI ZRAKOPLOVAC (Croatian Airman) \n" +
                "\n" +
                "Carries reports on the activities of the Croatian Army, reviews \n" +
                "of new weapons and interviews with military and political \n" +
                "leaders. \n" +
                "\n" +
                "NEDJELJNA DALMACIJA \n" +
                "\n" +
                "Sourceline:              Split NEDJELJNA DALMACIJA in \n" +
                "                         Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     Weekly Dalmatia \n" +
                "\n" +
                "Type of publication:     Weekly newspaper \n" +
                "\n" +
                "Day of publication:      Wednesday \n" +
                "\n" +
                "Publisher:               Slobodna Dalmacija--Novine, \n" +
                "                         Novinsko-Nakladnicke Djelatnosti \n" +
                "\n" +
                "Address:                 Ulica Ivana Gundulica 23, Split \n" +
                "\n" +
                "Chief editor:            Miroslav Ivic \n" +
                "\n" +
                "Carries reports and commentaries on domestic and foreign issues \n" +
                "by prominent journalists and politicians; shares much of its \n" +
                "writing staff with the daily SLOBODNA DALMACIJA. \n" +
                "\n" +
                "NOVI LIST \n" +
                "\n" +
                "Sourceline:              Rijeka NOVI LIST in Serbo-Croatian; \n" +
                "                         Rijeka TJEDNI NOVI LIST on Sunday \n" +
                "\n" +
                "Translation of name:     New Newspaper; Weekly New Newspaper \n" +
                "\n" +
                "Masthead caption:        \"NOVI LIST Was Founded by Frno Supilo on \n" +
                "                         2 January 1900\" \n" +
                "\n" +
                "Type of publication:     Newspaper \n" +
                "\n" +
                "Days of publication:     NOVI LIST on Monday-Saturday; TJEDNI \n" +
                "                         NOVI LIST on Sunday \n" +
                "\n" +
                "Publisher:               Novi List \n" +
                "\n" +
                "Address:                 Zvonimirova 20/a, Rijeka \n" +
                "\n" +
                "Director:                Zdenko Mance \n" +
                "\n" +
                "Chief editor:            Veljko Vicevic \n" +
                "\n" +
                "Under the ownership of a private company, led by Director Mance, \n" +
                "this formerly government-owned newspaper has established its \n" +
                "independence from government influence.  The paper has adopted a \n" +
                "generally nonpartisan editorial policy critical of both the \n" +
                "government and opposition parties. \n" +
                "\n" +
                "SLOBODNA DALMACIJA \n" +
                "\n" +
                "Sourceline:              Split SLOBODNA DALMACIJA in \n" +
                "                         Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     Free Dalmatia \n" +
                "\n" +
                "Masthead caption:        \"The First Private Croatian Daily\" \n" +
                "\n" +
                "Type of publication:     Daily newspaper \n" +
                "\n" +
                "Publisher:               Slobodna Dalmacij a--Novine, \n" +
                "                         Novinsko-Nakladnicke Djelatnosti \n" +
                "\n" +
                "Address:                 Ulica Hrvatske Mornarice 4, Split \n" +
                "\n" +
                "Director:                Ante Busic \n" +
                "\n" +
                "Chief editor:            Dino Mikulandra \n" +
                "\n" +
                "In the early days of President Tudjman's government, the paper \n" +
                "maintained an independent editorial policy and was frequently \n" +
                "sharply critical of the authorities.  It has become less critical \n" +
                "of the government since the spring of 1993, when \n" +
                "government-controlled institutions bought a controlling interest \n" +
                "in the paper during a \"privatization\" process and replaced most \n" +
                "of its management. \n" +
                "\n" +
                "VECERNJI LIST \n" +
                "\n" +
                "Sourceline:              Zagreb VECERNJI LIST in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     Evening Newspaper \n" +
                "\n" +
                "Masthead caption:        \"Independent Newspaper\" \n" +
                "\n" +
                "Type of publication:     Newspaper \n" +
                "\n" +
                "Days of publication:     Daily \n" +
                "\n" +
                "Publisher:               Vecernji List \n" +
                "\n" +
                "Address:                 Slavonska Avenija 4, 41000 Zagreb \n" +
                "\n" +
                "Director:                Branko Lovric \n" +
                "\n" +
                "Chief editor:            Branko Tudjen \n" +
                "\n" +
                "Tabloid format; largest circulation Croatian daily.  Generally \n" +
                "supportive of the government. \n" +
                "VJESNIK \n" +
                "\n" +
                "Sourceline:              Zagreb VJESNIK in Serbo-Croatian; Zagreb \n" +
                "                         NEDJELJNI VJESNIK in Serbo-Croatian \n" +
                "Translation of name:     Herald; Sunday Herald \n" +
                "\n" +
                "Masthead caption:        \"Croatian Political Daily\" \n" +
                "\n" +
                "Type of publication:     Newspaper \n" +
                "\n" +
                "Days of publication:     VJESNIK on Monday-Saturday; NEDJELJNI \n" +
                "                         VJESNIK on Sunday \n" +
                "\n" +
                "Publisher:               Novi Vjesnik \n" +
                "\n" +
                "Address:                 Slavonska Avenija 4, 41000 Zagreb \n" +
                "\n" +
                "Director:                Davor Perkovic \n" +
                "\n" +
                "Chief editor:            Kresimir Fijacko \n" +
                "\n" +
                "Leading Croatian paper, regarded in Zagreb as the paper of \n" +
                "record.  Provides broad national coverage, including interviews \n" +
                "with prominent politicians, commentaries, and international news. \n" +
                "Generally supportive of the government. \n" +
                "\n" +
                "   RADIO \n" +
                "\n" +
                "ZAGREB RADIO \n" +
                "\n" +
                "Sourceline:              Zagreb Radio Croatia Network in \n" +
                "                         Serbo-Croatian \n" +
                "\n" +
                "Station identification:  \"Radio Croatia, Zagreb Studio\" \n" +
                "\n" +
                "Other languages:         English (Several brief newscasts daily \n" +
                "                         in English) \n" +
                "\n" +
                "Principal frequencies:   594, 774, 1125, 1134, 1143, 5025, 6150, \n" +
                "                         9830, 13830 kHz \n" +
                "\n" +
                "Hours of operation:      24 hours \n" +
                "\n" +
                "Croatian Government-funded domestic and international radio \n" +
                "services.  Newscasts almost always represent the views of the \n" +
                "Croatian Government and the ruling Croatian Democratic Community \n" +
                "(HDZ). \n" +
                "\n" +
                "   TELEVISION \n" +
                "\n" +
                "ZAGREB TELEVISION \n" +
                "\n" +
                "Sourceline:              Zagreb HTV Television in Serbo-Croatian \n" +
                "\n" +
                "Station identification:  \"Croatian Television\" \n" +
                "\n" +
                "Hours of operation:      Monday, Thursday 0810-0000 GMT; Tuesday, \n" +
                "                         Wednesday 0810-0045 GMT; Friday \n" +
                "                         0810-0300 GMT; Saturday, Sunday \n" +
                "                         0825-0015 GMT \n" +
                "\n" +
                "Director:                Branko Lentic \n" +
                "\n" +
                "Government-funded television service.  Main newscasts almost \n" +
                "always represent the views of the Croatian Government and the \n" +
                "ruling Croatian Democratic Community (HDZ).  Other public affairs \n" +
                "broadcasts have occasionally been criticized by government \n" +
                "officials for their editorial content. \n" +
                "\n" +
                "   NEWS AGENCIES \n" +
                "\n" +
                "HINA \n" +
                "\n" +
                "Sourceline:              Zagreb HINA in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     HINA is an acronym for \"Croatian Press \n" +
                "                         Agency\" (Hrvatska Informativna Novinska \n" +
                "                         Agencija) \n" +
                "\n" +
                "Other languages:         English \n" +
                "\n" +
                "Official press agency of the Republic of Croatia, founded in \n" +
                "1991.  Extensively quoted by Croatian radio, television, and \n" +
                "press. \n" +
                "\n" +
                "   THE FORMER YUGOSLAV REPUBLIC OF MACEDONIA (FYROM) \n" +
                "\n" +
                "   PUBLICATIONS \n" +
                "\n" +
                "FLAKA E VELLAZERIMIT \n" +
                "\n" +
                "Sourceline:              Skopje FLAKA E VELLAZERIMIT in Albanian \n" +
                "\n" +
                "Translation of name:     Flame of Brotherhood \n" +
                "\n" +
                "Type of publication:     Newspaper \n" +
                "\n" +
                "Days of publication:     Sunday, Wednesday, Friday \n" +
                "\n" +
                "Publisher:               Nova Makedonija \n" +
                "\n" +
                "Address:                 Mito Hadzivasilev Jasmin, 91000 Skopje \n" +
                "\n" +
                "Director:                Pande Kolemisevski \n" +
                "\n" +
                "Chief editor:            Abdulhadi Zylfiqari \n" +
                "\n" +
                "Newspaper of the Albanian minority in FYROM; concentrates on \n" +
                "reports about the Albanian community, but also reports on other \n" +
                "events in FYROM and occasionally Kosovo and Albania.  Although a \n" +
                "part of the Nova Makedonija publishing company, which publishes \n" +
                "the country's major Macedonian-language newspapers (see below), \n" +
                "the newspaper follows a staunchly independent editorial policy \n" +
                "that is often sharply critical of the Slavic Macedonian political \n" +
                "parties. \n" +
                "\n" +
                "NOVA MAKEDONIJA \n" +
                "\n" +
                "Sourceline:              Skopje NOVA MAKEDONIJA in Macedonian \n" +
                "\n" +
                "Translation of name:     New Macedonia \n" +
                "\n" +
                "Type of publication:     Newspaper \n" +
                "\n" +
                "Days of publication:     Daily \n" +
                "\n" +
                "Publisher:               Nova Makedonija Newspaper Publishing \n" +
                "                         Enterprise \n" +
                "\n" +
                "Address:                 Mito Hadzivasilev Jasmin, 910O0 Skopje \n" +
                "\n" +
                "Director:                Pande Kolemisevski \n" +
                "Chief editor:            Georgi Ajanovski \n" +
                "\n" +
                "Flagship newspaper of the Nova Makedonija publishing company; \n" +
                "like other newspapers in the company, appears to set its \n" +
                "editorial policy independently.  Generally supportive of \n" +
                "President Kiro Gligorov, but frequently critical of the coalition \n" +
                "government.  Covers domestic and foreign news, with greater \n" +
                "emphasis on the former.  Tends to give more extensive coverage to \n" +
                "the Liberal Party than to other Macedonian parties.  The paper of \n" +
                "record in Skopje. \n" +
                "\n" +
                "ODBRANA \n" +
                "\n" +
                "Sourceline:              Skopje ODBRANA in Macedonian \n" +
                "\n" +
                "Translation of name:     Defense \n" +
                "\n" +
                "Type of publication:     Magazine \n" +
                "\n" +
                "Dates of publication:    Six times yearly \n" +
                "\n" +
                "Publisher:               Macedonian Defense Ministry \n" +
                "\n" +
                "Address:                 Ulica Orce Nikolov, 91000 Skopje \n" +
                "\n" +
                "Chief editor:            Aleksa Stamenkovski \n" +
                "\n" +
                "Carries articles on politics, social issues, military affairs, \n" +
                "reviews of weapons. \n" +
                "\n" +
                "PULS \n" +
                "\n" +
                "Sourceline:              Skopje PULS in Macedonian \n" +
                "\n" +
                "Translation of name:     Pulse \n" +
                "\n" +
                "Masthead caption:        \"Independent Weekly\" \n" +
                "\n" +
                "Type of publication:     Weekly newspaper \n" +
                "\n" +
                "Day of publication:      Friday \n" +
                "\n" +
                "Publisher:               Nova Makedonija \n" +
                "\n" +
                "Address:                 Mito Hadzivasilev Jasmin, 91000 Skopje \n" +
                "\n" +
                "Director:                Pande Kolemisevski \n" +
                "\n" +
                "Chief editor:            Vasil Mickovski \n" +
                "\n" +
                "Carries articles, commentaries, and interviews on domestic and \n" +
                "foreign affairs; sometimes critical of the government.  Style \n" +
                "suggests that the paper is aimed at intellectuals. \n" +
                "\n" +
                "VECER \n" +
                "\n" +
                "Sourceline:              Skopje VECER in Macedonian \n" +
                "\n" +
                "Translation of name:     Evening \n" +
                "\n" +
                "Type of publication:     Newspaper \n" +
                "\n" +
                "Days of publication:     Monday-Saturday \n" +
                "\n" +
                "Publisher:               Nova Makedonija \n" +
                "\n" +
                "Address:                 Mito Hadzivasilev Jasmin, 91000 Skopje \n" +
                "\n" +
                "Chief editor:            Stojan Nasev \n" +
                "\n" +
                "Popular, tabloid-style newspaper; coverage sometimes borders on \n" +
                "sensationalism but occasionally carries investigative reports \n" +
                "that hint at government corruption. \n" +
                "\n" +
                "   RADIO \n" +
                "\n" +
                "SKOPJE RADIO \n" +
                "\n" +
                "Sourceline:              Skopje Radio Macedonia Network in \n" +
                "                         Macedonian \n" +
                "\n" +
                "Station identification:  \"You are listening to the daily \n" +
                "                         chronicle of the national channel of \n" +
                "                         Radio Macedonia\" \n" +
                "\n" +
                "Other languages:         Bulgarian \n" +
                "\n" +
                "Principal frequencies:   810, 1242, 1485 kHz \n" +
                "\n" +
                "Hours of operation:      24 hours \n" +
                "\n" +
                "Reflects the views of the FYROM Government. \n" +
                "\n" +
                "   NEWS AGENCIES \n" +
                "\n" +
                "MIC \n" +
                "\n" +
                "Sourceline:              Skopje MIC in English \n" +
                "\n" +
                "Translation of name:     MIC is an acronym for \"Macedonian \n" +
                "                         Information Center\" (Makedonski \n" +
                "                         Informativen Centar) \n" +
                "\n" +
                "Type of publication:     Fax/modem news digest \n" +
                "\n" +
                "Days of publication:     Monday-Friday \n" +
                "\n" +
                "Publisher:               Macedonian Information Center \n" +
                "\n" +
                "Address:                 Orce Nikolov 28, 91000 Skopje \n" +
                "\n" +
                "Director:                Saso Ordanoski \n" +
                "\n" +
                "The Macedonian Information Center is affiliated with the World \n" +
                "Macedonian Congress, a non-party, non-governmental organization \n" +
                "whose stated aims are \"to assist the Republic of Macedonia in its \n" +
                "economic, scientific, and technological development and in the \n" +
                "promotion of Macedonian culture in Europe and throughout the \n" +
                "world.\"  The MIC news digest was first issued on 1 October 1993. \n" +
                "\n" +
                "MILS-NEWS \n" +
                "\n" +
                "Sourceline:              Skopje MILS-NEWS in English \n" +
                "\n" +
                "Translation of name:     MILS is an acronym for \"Macedonian \n" +
                "                         Information and Liaison Service\" \n" +
                "                         (Makedonski Centar Za Informacii I \n" +
                "                         Vrski) \n" +
                "\n" +
                "Type of publication:     Fax/modem news digest \n" +
                "\n" +
                "Days of publication:     Monday-Friday \n" +
                "Publisher:               Macedonian Information and Liaison \n" +
                "                         Service \n" +
                "\n" +
                "Address:                 91000 Skopje \n" +
                "\n" +
                "Director:                Ljupco Naumovski \n" +
                "\n" +
                "MILS is the international bureau of the Australian-Macedonian \n" +
                "Society and is supported by the Ilenden Foundation. \n" +
                "\n" +
                "   SLOVENIA \n" +
                "\n" +
                "   PUBLICATIONS \n" +
                "\n" +
                "DELO \n" +
                "\n" +
                "Sourceline:              Ljubljana DELO in Slovene \n" +
                "\n" +
                "Translation of name:     Labor \n" +
                "\n" +
                "Masthead caption:        \"Independent Newspaper for Independent \n" +
                "                                   Slovenia\" \n" +
                "\n" +
                "Type of publication:     Newspaper \n" +
                "\n" +
                "Days of publication:     Monday-Saturday \n" +
                "\n" +
                "Publisher:               CZP Delo \n" +
                "\n" +
                "Address:                 Dunajska 5, 61000 Ljubljana \n" +
                "\n" +
                "Chief editor:            Tit Dobersek \n" +
                "\n" +
                "Editorial content includes diverse viewpoints.  Covers domestic \n" +
                "and international affairs extensively; carries many commentaries \n" +
                "and interviews. \n" +
                "\n" +
                "DNEVNIK \n" +
                "\n" +
                "Sourceline:              Ljubljana DNEVNIK in Slovene \n" +
                "\n" +
                "Translation of name:     Daily \n" +
                "\n" +
                "Type of publication:     Newspaper \n" +
                "\n" +
                "Days of Publication:     Monday-Friday \n" +
                "\n" +
                "Publisher:               Dnevnik \n" +
                "\n" +
                "Address:                 Kopitarjeva 2, 61000 \n" +
                "\n" +
                "Director:                Ada Gorjup \n" +
                "\n" +
                "Chief editor:            Zlatko Setinc \n" +
                "\n" +
                "Generally supports the views of social-democratic parties and \n" +
                "occasionally moderate liberal parties.  Devotes more attention to \n" +
                "domestic than international affairs, using press agency \n" +
                "dispatches for the latter; also carries commentaries and \n" +
                "interviews. \n" +
                "\n" +
                "MLADINA \n" +
                "\n" +
                "Sourceline:              Ljubljana MLADINA in Slovene \n" +
                "\n" +
                "Translation of name:     Youth \n" +
                "Type of publication:     Weekly magazine \n" +
                "\n" +
                "Day of publication:      Tuesday \n" +
                "\n" +
                "Publisher:               Mladina DTP \n" +
                "\n" +
                "Address:                 Resljeva 16, 61000 Ljubljana \n" +
                "\n" +
                "Director:                Andrej Poznic \n" +
                "\n" +
                "Chief editor:            Robert Botteri \n" +
                "\n" +
                "Unaffiliated political weekly, which has uninterruptedly voiced \n" +
                "opposition views regardless of which parties have formed the \n" +
                "government. \n" +
                "\n" +
                "OSLOBODJENJE \n" +
                "\n" +
                "Sourceline:              Ljubljana OSLOBODJENJE (Europe Edition) \n" +
                "                         in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     Liberation \n" +
                "\n" +
                "Masthead caption:        \"European Weekly Edition\" \n" +
                "\n" +
                "Type of publication:     Weekly newspaper \n" +
                "\n" +
                "Day of publication:      Irregular \n" +
                "\n" +
                "Publisher:               Oslobodj enj e (Saraj evo) \n" +
                "\n" +
                "Address:                 Dunajska 5, 61000 Ljubljana, Slovenia \n" +
                "\n" +
                "Director:                Salko Hasanefendic \n" +
                "\n" +
                "Chief editor:            Midhad Plivcic \n" +
                "\n" +
                "A weekly produced in Slovenia, summarizing the views of the daily \n" +
                "edition of OSLOBODJENJE, published in Sarajevo.  The daily \n" +
                "edition (not regularly distributed outside Sarajevo) is produced \n" +
                "by a multi-ethnic staff, which has stayed together despite the \n" +
                "Bosnian civil war. \n" +
                "\n" +
                "SLOVENEC \n" +
                "\n" +
                "Sourceline:              Ljubljana SLOVENEC in Slovene \n" +
                "\n" +
                "Translation of name:     The Slovene \n" +
                "\n" +
                "Masthead caption:        \"Newspaper for Politics, Economics, \n" +
                "                         Culture, and Religion\" \n" +
                "\n" +
                "Type of publication:     Newspaper \n" +
                "\n" +
                "Days of publication:     Monday-Saturday \n" +
                "\n" +
                "Publisher:               Slovenec Ltd. \n" +
                "\n" +
                "Address:                 Dunajska 9, Ljubljana 61000 \n" +
                "\n" +
                "Director:                Janez Obreza \n" +
                "\n" +
                "Chief editor:            Jani Virk \n" +
                "\n" +
                "Promotes the views of the center-right Christian Democratic \n" +
                "Party, the Democratic People's Party, and Liberal Democratic \n" +
                "Party.  Focuses on domestic issues; primarily uses press agency \n" +
                "reports to cover international affairs; carries some commentaries \n" +
                "and interviews. \n" +
                "\n" +
                "   RADIO \n" +
                "\n" +
                "LJUBLJANA RADIO \n" +
                "\n" +
                "Sourceline:              Ljubljana Radio Slovenia Network in \n" +
                "                         Slovene \n" +
                "\n" +
                "Station identification:  \"Radio Slovenija, First and Second \n" +
                "                         Program\" \n" +
                "\n" +
                "Principal frequencies:   918, 7215, 9720, 15105 kHz \n" +
                "\n" +
                "Hours of operation:      24 hours \n" +
                "\n" +
                "Generally reflects views of the Slovene Government. \n" +
                "\n" +
                "   FEDERAL REPUBLIC OF YUGOSLAVIA \n" +
                "\n" +
                "   KOSOVO \n" +
                "\n" +
                "   PUBLICATIONS \n" +
                "\n" +
                "BUJKU \n" +
                "\n" +
                "Sourceline:              Pristina BUJKU in Albanian \n" +
                "\n" +
                "Translation of name:     The Peasant \n" +
                "\n" +
                "Masthead caption:        \"Periodical for Social Issues in the \n" +
                "                         Countryside\" \n" +
                "\n" +
                "Type of publication:     Newspaper \n" +
                "\n" +
                "Days of publication:     Issued five to six times per week; no \n" +
                "                         regular days \n" +
                "\n" +
                "Publisher:               Rilindja Enterprise \n" +
                "\n" +
                "Address:                 Pallati i Shtypit, Pristina \n" +
                "\n" +
                "Chief editor:            Behlul Jashari \n" +
                "\n" +
                "BUJKU was formerly a publication for peasant farmers.  Since the \n" +
                "banning of the Albanian-language daily RILINDJA in 1990, it \n" +
                "gradually become a current affairs publication concentrating on \n" +
                "Kosovar, Yugoslav, and world politics.  Has supported the rights \n" +
                "of Kosovo Albanians.  Employs a number of former RILINDJA \n" +
                "journalists. \n" +
                "\n" +
                "   RADIO \n" +
                "\n" +
                "PRISTINA RADIO \n" +
                "\n" +
                "Sourceline:              Pristina Radio Pristina Network in \n" +
                "                         Albanian \n" +
                "\n" +
                "Principal frequencies:   1413, 1539 kHz \n" +
                "\n" +
                "Hours of operation:      0400-2305 GMT \n" +
                "\n" +
                "Operated by the Serbian Radio and Television Network; carries \n" +
                "largely the same material as Belgrade radio. \n" +
                "   TELEVISION \n" +
                "\n" +
                "PRISTINA TELEVISION \n" +
                "\n" +
                "Sourceline:              Pristina TVP Television Network in \n" +
                "                         Serbo-Croatian \n" +
                "\n" +
                "Station identification:  \"Pristina Television\" \n" +
                "\n" +
                "See entry under Belgrade RTB Television Network, page 28. \n" +
                "\n" +
                "   NEWS AGENCIES \n" +
                "\n" +
                "KOSOVA DAILY REPORT \n" +
                "\n" +
                "Sourceline:              Pristina KOSOVA DAILY REPORT in English \n" +
                "\n" +
                "Type of publication:     Faxed news digest \n" +
                "\n" +
                "Days of publication:     Monday-Friday \n" +
                "\n" +
                "Publisher:               Democratic Alliance of Kosovo \n" +
                "\n" +
                "Address:                 38000 Pristina \n" +
                "\n" +
                "Digest of news reports on Kosovar affairs prepared by the \n" +
                "Democratic Alliance of Kosova, the largest Albanian opposition \n" +
                "party in Kosovo. \n" +
                "\n" +
                "   MONTENEGRO \n" +
                "\n" +
                "   PUBLICATIONS \n" +
                "\n" +
                "MONITOR \n" +
                "\n" +
                "Sourceline:              Podgorica MONITOR in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     Monitor \n" +
                "\n" +
                "Masthead caption:        \"Montenegrin Independent Weekly\" \n" +
                "\n" +
                "Type of publication:     Weekly magazine \n" +
                "\n" +
                "Day of publication:      Friday \n" +
                "\n" +
                "Publisher:               Montenegropublic, Podgorica (privately \n" +
                "                         owned) \n" +
                "\n" +
                "Address:                 Ulica 19 Decembra Broi 19, 81000 \n" +
                "                         Podgori ca \n" +
                "\n" +
                "Director:                Miodrag Perovic \n" +
                "\n" +
                "Chief editor:            Esad Kocan \n" +
                "\n" +
                "Independent magazine that publishes commentaries, interviews, \n" +
                "articles.  Frequently critical of Serbian, Montenegrin, and \n" +
                "Federal Republic of Yugoslavia officials. \n" +
                "\n" +
                "POBJEDA \n" +
                "\n" +
                "Sourceline:              Podgorica POBJEDA in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     Victory \n" +
                "\n" +
                "Masthead caption:        \"Founded by the Montenegrin Assembly\" \n" +
                "Type of publication:     Newspaper \n" +
                "\n" +
                "Days of publication:     Monday-Saturday \n" +
                "\n" +
                "Address:                 Bulevar Revolucije 11, 81000 Podgorica \n" +
                "\n" +
                "Director/Chief editor:   Nikola Ivanovic \n" +
                "\n" +
                "Reflects the views of the government of Montenegro. \n" +
                "\n" +
                "   TELEVISION \n" +
                "\n" +
                "PODGORICA TELEVISION \n" +
                "\n" +
                "Sourceline:              Podgorica TVCG Television Network in \n" +
                "                         Serbo-Croatian \n" +
                "\n" +
                "Station identification:  \"Montenegro Television\" \n" +
                "\n" +
                "See entry under Belgrade RTB Television Network, page 28. \n" +
                "\n" +
                "   SERBIA \n" +
                "\n" +
                "   PUBLICATIONS \n" +
                "\n" +
                "BORBA \n" +
                "\n" +
                "Sourceline:              Belgrade BORBA in Serbo-Croatian; \n" +
                "                         Belgrade NEDELJNA BORBA in \n" +
                "                         Serbo-Croat ian \n" +
                "\n" +
                "Translation of name:     Struggle; Sunday Struggle \n" +
                "\n" +
                "Masthead caption:        \"Independent Political Daily\" \n" +
                "\n" +
                "Type of publication:     Newspaper \n" +
                "\n" +
                "Days of publication:     BORBA on Monday-Friday; NEDELJNA BORBA \n" +
                "                         (Saturday-Sunday edition) on Saturday \n" +
                "\n" +
                "Publisher:               Borba \n" +
                "\n" +
                "Address:                 Trg Nikole Pasica 7, 11000 Belgrade \n" +
                "\n" +
                "Director:                Dusan Mijic \n" +
                "\n" +
                "Chief editor:            Slavko Curuvija \n" +
                "\n" +
                "Staunchly independent, nonpartisan newspaper, recently taken over \n" +
                "by a new private owner.  Contains broad coverage of domestic and \n" +
                "foreign affairs; frequently critical of the government of \n" +
                "President Slobodan Milosevic and federal authorities. \n" +
                "\n" +
                "DUGA \n" +
                "\n" +
                "Sourceline:              Belgrade DUGA in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     Rainbow \n" +
                "\n" +
                "Type of publication:     Biweekly magazine \n" +
                "\n" +
                "Day of publication:      Every other Saturday \n" +
                "\n" +
                "Publisher:               Beogradski Izdavacko-Graficki Zavod \n" +
                "\n" +
                "Address:                 Bulevar Vojvode Misic, 11000 Belgrade \n" +
                "Director/Chief editor:   Ilija Rapaic \n" +
                "\n" +
                "Independent biweekly that carries political and social commentary \n" +
                "as well as articles focusing on popular culture.  Regularly \n" +
                "carries a column of political commentary written by Mirjana \n" +
                "Markovic--Milosevic's wife--that often criticizes the Serbian \n" +
                "nationalist cause. \n" +
                "\n" +
                "EKONOMSKA POLITIKA \n" +
                "\n" +
                "Sourceline:              Belgrade EKONOMSKA POLITIKA in \n" +
                "                         Serbo-Croatian \n" +
                "Translation of name:     Economic Policy \n" +
                "\n" +
                "Type of publication:     Weekly magazine \n" +
                "\n" +
                "Day of publication:      Monday \n" +
                "\n" +
                "Publisher:               Ekonomska Poli tika \n" +
                "\n" +
                "Address:                 Trg Nikole Pasica 7, 11001 Belgrade \n" +
                "\n" +
                "Director/Chief editor:   Milutin Mitrovic \n" +
                "\n" +
                "Carries articles, statistics, and interviews on economic and \n" +
                "business affairs; has criticized the economic policies of the \n" +
                "Serbian Republic and the federal government. \n" +
                "\n" +
                "INTERVJU \n" +
                "\n" +
                "Sourceline:              Belgrade INTERVJU in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     Interview \n" +
                "\n" +
                "Type of publication:     Weekly magazine \n" +
                "\n" +
                "Day of publication:      Friday \n" +
                "\n" +
                "Publisher:               Politika \n" +
                "\n" +
                "Address:                 Cetinjska 3-III, 11001 Beograd \n" +
                "\n" +
                "Chief editor:            Dragan Vlahovic \n" +
                "\n" +
                "Independent news weekly; carries interviews with prominent \n" +
                "politicians, as well as articles and commentary on political, \n" +
                "economic, and social issues. \n" +
                "\n" +
                "NIN \n" +
                "\n" +
                "Sourceline:              Belgrade NIN in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     NIN is an acronym for \"Weekly \n" +
                "                         Information Newspaper\" \n" +
                "\n" +
                "Type of publication:     Weekly magazine \n" +
                "\n" +
                "Day of publication:      Friday \n" +
                "\n" +
                "Publisher:               NIN \n" +
                "\n" +
                "Address:                 Cetinska 1, Belgrade \n" +
                "\n" +
                "Director/Chief editor:   Dusan Velickovic \n" +
                "\n" +
                "Independent news weekly; generally supports moderate Serbian \n" +
                "nationalism; often criticizes the policies of the Serbian \n" +
                "Government; also frequently critical of the Bosnian Government \n" +
                "and both the Croatian Government and the Bosnian Croats. \n" +
                "\n" +
                "POLITIKA \n" +
                "\n" +
                "Sourceline:              Belgrade POLITIKA in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     Politics \n" +
                "\n" +
                "Type of publication:     Newspaper \n" +
                "\n" +
                "Days of publication:     Daily \n" +
                "\n" +
                "Publisher:               Poli tika \n" +
                "\n" +
                "Address:                 Makedonska 29, 11000 Belgrade \n" +
                "\n" +
                "Director:                Hadzi Dragan Antic \n" +
                "\n" +
                "Chief editor:            Bosko Jaksic \n" +
                "\n" +
                "Independent newspaper; flagship daily of the Politika publishing \n" +
                "company and the paper of record in Serbia.  In 1992 Director \n" +
                "Minovic, an erstwhile Milosevic stalwart, surrendered control \n" +
                "over policy to the newly independent Politika editors.  Politika, \n" +
                "although critical of the regime between mid-1992 and the summer \n" +
                "of 1993, has since adopted a more pro-government stance. \n" +
                "\n" +
                "POLITIKA EKSPRES \n" +
                "\n" +
                "Sourceline:              Belgrade POLITIKA EKSPRES in \n" +
                "                         Serbo-Croat ian \n" +
                "\n" +
                "Translation of name:     Politics Express \n" +
                "\n" +
                "Masthead caption:        \"Evening Newspaper\" \n" +
                "\n" +
                "Type of publication:     Newspaper \n" +
                "\n" +
                "Days of publication:     Daily \n" +
                "\n" +
                "Publisher:               Politika \n" +
                "\n" +
                "Address:                 Makedonska 29, 11000 Belgrade \n" +
                "\n" +
                "Director:                Zivorad Minovic \n" +
                "\n" +
                "Chief editor:            Mile Kordic \n" +
                "\n" +
                "Tabloid-style newspaper; although independent, generally supports \n" +
                "the Serbian Government and its policies; strongly supports \n" +
                "Serbian nationalism. \n" +
                "\n" +
                "SRPSKA REC \n" +
                "\n" +
                "Sourceline:              Belgrade SRPSKA REC in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     Serbian Word \n" +
                "\n" +
                "Masthead caption:        \"Free Newspaper\" \n" +
                "\n" +
                "Type of publication:     Biweekly magazine \n" +
                "\n" +
                "Day of publication:      Monday \n" +
                "\n" +
                "Publisher:               Free Journalists \n" +
                "\n" +
                "Address:                 Brankova 13-15, 11000 Beograd \n" +
                "\n" +
                "Chief editor:            Bogoljub Pejcic \n" +
                "\n" +
                "Newspaper of the Serbian Renewal Movement; its editorial stance \n" +
                "is strongly oppositionist and Serbian nationalist. \n" +
                "\n" +
                "VECERNJE NOVOSTI \n" +
                "\n" +
                "Sourceline:              Belgrade VECERNJE NOVOSTI in \n" +
                "                         Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     Evening News \n" +
                "\n" +
                "Masthead caption:        \"Daily With the Largest Circulation in \n" +
                "                         the Federal Republic of Yugoslavia\" \n" +
                "\n" +
                "Type of publication:     Daily newspaper \n" +
                "\n" +
                "Publisher:               Izadavacko Preduzece Novosti \n" +
                "\n" +
                "Address:                 Trg Nikole Pasica 7, Beograd \n" +
                "\n" +
                "Chief editor:            Radisav Rade Brajovic \n" +
                "\n" +
                "A tabloid that strongly supports the Serbian Government and \n" +
                "Serbian nationalism. \n" +
                "\n" +
                "VOJSKA \n" +
                "\n" +
                "Sourceline:              Belgrade VOJSKA in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     Army \n" +
                "\n" +
                "Type of publication:     Weekly magazine \n" +
                "\n" +
                "Publisher:               Federal Ministry of Defense \n" +
                "\n" +
                "Address:                 Bircaninova 5, Belgrade \n" +
                "\n" +
                "Acting chief editor:     Stanoje Jovanovic \n" +
                "\n" +
                "Changed name from NARODNA ARMIJA on 1 June 1992; military weekly \n" +
                "magazine targeted at commissioned and noncommissioned officers; \n" +
                "strongly supportive of the Milosevic regime and the Serbian \n" +
                "nationalist cause in Bosnia-Herzegovina and Croatia. \n" +
                "\n" +
                "VREME \n" +
                "\n" +
                "Sourceline:              Belgrade VREME in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     Time \n" +
                "\n" +
                "Type of publication:     Weekly magazine \n" +
                "\n" +
                "Day of publication:      Monday \n" +
                "\n" +
                "Publisher:               Vreme \n" +
                "\n" +
                "Address:                 Narodnog Fronta 45/VII, 11000 Belgrade \n" +
                "\n" +
                "Director:                Ivan Mrdjen \n" +
                "\n" +
                "Chief editor:            Dragoljub Zarkovic \n" +
                "Current affairs weekly that pursues a staunchly independent \n" +
                "editorial policy; often sharply critical of the Milosevic regime \n" +
                "and the varieties of nationalism espoused in the Balkans. \n" +
                "\n" +
                "   RADIO \n" +
                "\n" +
                "BELGRADE RADIO \n" +
                "\n" +
                "Sourceline:              Belgrade Radio Beograd Network in \n" +
                "                         Serbo-Croat ian \n" +
                "\n" +
                "Station identification:  \"Serbian Radio and Television -- Radio \n" +
                "                         Belgrade First Program\" \n" +
                "\n" +
                "Principal frequencies:   684, 7200 kHz \n" +
                "\n" +
                "Hours of operation:      24 hours \n" +
                "\n" +
                "Reflects the view of the regime of President Slobodan Milosevic, \n" +
                "although not as tightly controlled as is Belgrade television. \n" +
                "Provides news from Yugoslavia, former Yugoslav republics, other \n" +
                "countries. \n" +
                "\n" +
                "   TELEVISION \n" +
                "\n" +
                "BELGRADE TELEVISION \n" +
                "\n" +
                "Sourceline:              Belgrade RTB Television Network in \n" +
                "                         Serbo-Croat ian \n" +
                "\n" +
                "                         Other Studios: \n" +
                "                         Novi Sad TVNS Television Network in \n" +
                "                         Serbo-Croa t i an \n" +
                "                         Podgorica TVCG Television Network in \n" +
                "                         Serbo-Croa t i an \n" +
                "                         Pristina TVP Television Network in \n" +
                "                         Serbo-Croa t i an \n" +
                "\n" +
                "Station identification:  \"Radio Televizija Beograd\" and \"Serbian \n" +
                "                         Radio and Television Satellite Program\" \n" +
                "\n" +
                "Hours of operation:      0715-0030 GMT (Monday-Friday); 0730-0015 \n" +
                "                         GMT (Saturday-Sunday) \n" +
                "\n" +
                "Newscasts:               1830 GMT, 2130 GMT (daily) and 1600 GMT \n" +
                "                         (Monday-Friday); 1630 GMT (Saturday); \n" +
                "                         1255 GMT (Sunday) \n" +
                "\n" +
                "Under tight control of Milosevic regime; fully utilized for the \n" +
                "promotion of the Socialist Party's ideas and policies.  Many \n" +
                "broadcasts are also relayed to Serb-populated regions of \n" +
                "Bosnia-Herzegovina and Croatia. \n" +
                "\n" +
                "FBIS monitors only the satellite transmission of this station, \n" +
                "which is carried six hours daily (1700-2300 GMT wintertime) and \n" +
                "is a compilation of broadcasts prepared by the studios of the \n" +
                "Serbian Television Network--Belgrade, Novi Sad, and Pristina--and \n" +
                "the Podgorica (Montenegro) television studio. \n" +
                "\n" +
                "   NEWS AGENCIES \n" +
                "\n" +
                "SRNA \n" +
                "\n" +
                "Sourceline:              Belgrade SRNA in Serbo-Croatian \n" +
                "\n" +
                "Translation of name:     Serbian Republic News Agency (Srpska \n" +
                "                         Novinska Agencija) \n" +
                "\n" +
                "Identification:          \"Belgrade 9840.  News by the SRNA \n" +
                "                         agency.\" \n" +
                "A recorded telephone message service, established to \"provide \n" +
                "news on the situation in Bosnia-Herzegovina to the citizens of \n" +
                "the Federal Republic of Yugoslavia, especially the refugees from \n" +
                "Bosnia-Herzegovina.\"  Represents the views of the leadership of \n" +
                "the so-called Republic of Srpska in Bosnia-Herzegovina. \n" +
                "\n" +
                "TANJUG \n" +
                "\n" +
                "Sourceline:              Belgrade TANJUG Domestic Service in \n" +
                "                         Serbo-Croatian; also Belgrade TANJUG in \n" +
                "                         English \n" +
                "\n" +
                "Translation of name:     TANJUG is an acronym for \"Telegraphic \n" +
                "                         Agency of New Yugoslavia\" (Telegrafska \n" +
                "                         Agencija Nove Jugoslavije) \n" +
                "\n" +
                "Principal frequencies:   5112 kHz (Serbo-Croatian); 7996, 13440 \n" +
                "                         kHz (English) \n" +
                "\n" +
                "Hours of operation:      Serbo-Croatian monitored 24 hours daily; \n" +
                "                         English monitored 0500-240O GMT \n" +
                "                         Monday-Friday and 0800-2100 GMT Saturday \n" +
                "                         and Sunday \n" +
                "\n" +
                "Government-funded radioteletype news service for the domestic \n" +
                "press (in Serbo-Croatian) and for international audiences (in \n" +
                "English).  Reflects views of the Milosevic regime. \n" +
                "\n" +
                "   VOJVODINA \n" +
                "\n" +
                "   PUBLICATIONS \n" +
                "\n" +
                "MAGYAR SZO \n" +
                "\n" +
                "Sourceline:              Novi Sad MAGYAR SZO in Hungarian \n" +
                "\n" +
                "Translation of name:     Hungarian Word \n" +
                "\n" +
                "Type of publication:     Newspaper \n" +
                "\n" +
                "Days of publication:     Thursday and Saturday \n" +
                "\n" +
                "Publisher:               The FORUM Newspaper and Book Printing \n" +
                "                         Industry Public Enterprise \n" +
                "\n" +
                "Address:                 Vojvode Misica 1, 21000 Novi Sad \n" +
                "\n" +
                "Director:                Gyula Gobby Feher \n" +
                "\n" +
                "Chief editor:            Sandor Balint \n" +
                "\n" +
                "Formerly a daily, the paper has been published twice a week since \n" +
                "late 1993, when it was cut back because of financial problems. \n" +
                "While MAGYAR SZO has been the main outlet for the views of the \n" +
                "Hungarian minority's only significant political organization, the \n" +
                "Democratic Community of Vojvodina Hungarians (DZVM), in late 1993 \n" +
                "some DZVM officials accused the paper of reducing its coverage of \n" +
                "the organization and of showing more support for the democratic \n" +
                "Serbian opposition than for the DZVM. \n" +
                "\n" +
                "   TELEVISION \n" +
                "\n" +
                "NOVI SAD TELEVISION \n" +
                "\n" +
                "Sourceline:              Novi Sad TVNS Television Network in \n" +
                "                         Serbo-Croatian \n" +
                "\n" +
                "Station identification:  \"Novi Sad Television\" \n" +
                "\n" +
                "\n" +
                "   See entry under Belgrade RTB Television Network,page 28. \n" +
                "\n" +
                "\n" +
                "\n" +
                "   Comments and queries regarding this media guide can be \n" +
                "directed to Chief Analyst, Europe/Latin America Group, at (703) \n" +
                "733-6120.  Comments and queries concerning the World Media Report \n" +
                "series can be directed to Media Assessment Branch, Global Issues \n" +
                "Group, at (703) 733-6131. \n" +
                "\n" +
                "   FBIS Media Guides are disseminated electronically to U.S. \n" +
                "Government offices that are regular FBIS sof t-copy customers, and \n" +
                "as a hard-copy publication to all U.S. Government subscribers who \n" +
                "regularly receive the corresponding geographic Daily Report. \n" +
                "Copies of this guide (FBIS MEDIA GUIDE: THE FORMER YUGOSLAVIA, \n" +
                "Document Number: WMR 94-001, Publication Date: 17 February 1994) \n" +
                "and subscriptions to FBIS Media Guides are available free of \n" +
                "charge to government offices from Requirements and Dissemination \n" +
                "Branch, Foreign Broadcast Information Service, P.O. Box 2604, \n" +
                "Washington, DC 20013-2604, Fax: (703) 733-6042.  For additional \n" +
                "information or assistance, call FBIS at (202) 338-6735. \n" +
                "Electronic customers may also request copies or subscriptions to \n" +
                "the hard-copy version by sending a message to the router \n" +
                "RUCWAAB/FBIS RESTON VA//ATTN RDB//. \n" +
                "GIG/28FEB94/OSD/PF 01/0305z Mar";

        Parse test=new Parse();
        test.parseIt(text);

    }

}
