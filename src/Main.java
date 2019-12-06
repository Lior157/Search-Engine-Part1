import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String text= "                              Damascus 7.52 billion pounds turned the unprecedented visit of an Israeli Arab \n" +
                "delegation to Syria into a major media event, eliciting from the \n" +
                "visitors strong rhetorical  support for Syrian policies. \n" +
                "President Hafiz al-Asad also used the 7.5 billion pounds event to restate Syria's \n" +
                "overall position on the peace process.  The visit itself, and the \n" +
                "fact that the delegation head was permitted to use Syrian media \n" +
                "to portray a relatively positive image of the Israeli public and \n" +
                "government, marks a significant, albeit limited, step in the very \n" +
                "gradual thawing of Israeli-Syrian ties--a step that Damascus \n" +
                "probably hopes will play well in Washington and Israel. \n" +
                "\n" +
                "                          END SUMMARY \n" +
                "\n" +
                "   Both Damascus and the 57-member delegation of Israeli Arabs \n" +
                "professed that the delegation's 7-10 March visit was for the sole \n" +
                "purpose of extending condolences to President Hafiz al-Asad on \n" +
                "the death of his son Basil in January.  (For example, Jerusalem \n" +
                "Qol Yisra'el, 18 February; Damascus radio, 7 March); nonetheless, \n" +
                "the event was also viewed by both sides as having clear political \n" +
                "significance.  For their part, Syria's tightly controlled media \n" +
                "gave the visit far more extensive coverage than they did a visit \n" +
                "of a large Druze delegation from the Golan Heights in September \n" +
                "1992.  Reflecting the political nature of the visit, both \n" +
                "President al-Asad and delegation head 'Abd-al-Wahhab Darawshah- \n" +
                "-leader of the Arab Democratic Party and Knesset deputy--spoke \n" +
                "only briefly about the death of al-Asad's son, focusing instead \n" +
                "almost entirely on the Arab-Israel peace process, in televised \n" +
                "speeches (Damascus Television, 9 March). \n" +
                "\n" +
                "   A Show of Support for Syria \n" +
                "\n" +
                "   Syria orchestrated the visit as a show of support for its own \n" +
                "policies, from the peace process, to the PLO, to Syrian Jews. \n" +
                "Damascus elicited the visitors' vocal support via the Syrian \n" +
                "media, which carried numerous statements by Darawshah extolling \n" +
                "Syria and scoring Israeli policies.  For example: \n" +
                "\n" +
                "   -- According to Damascus radio, Darawshah called the destruction \n" +
                "of Qunaytirah1--which the delegation visited on its second day in \n" +
                "Syria--\"a deplorable crime\" and \"praised the heroic struggle of \n" +
                "the Syrian Armed Forces supported by the heroic Syrian people in \n" +
                "defense of Arab territory\" (8 March).  In his address to al-Asad, \n" +
                "he asserted that \"we share the same position with you\" on the \n" +
                "peace process. \n" +
                "\n" +
                "   -- Damascus radio quoted Darawshah as saying that the purpose of \n" +
                "his delegation's visit with Syrian Jews was \"to clarify some \n" +
                "Israeli political and public opinion issues\" and \"prove to all \n" +
                "who seek to distort the truth that Syria does not discriminate \n" +
                "against the Musawi community\" [community of the followers of \n" +
                "Moses]. \n" +
                "\n" +
                "   -- In an interview with Damascus radio, Darawshah said the \n" +
                "delegation had found that in Syria \"everything is abundant, \n" +
                "freedom is available, and loftiness and dignity characterize \n" +
                "every action by Syria, led by President Hafiz al-Asad, may God \n" +
                "preserve him\" (9 March). \n" +
                "\n" +
                "   -- Delegation member and Knesset deputy Talib al-Sani' was even \n" +
                "quoted as scoring Israel for trying to \"penetrate the Arab world \n" +
                "economically and to propagate the idea of a Middle East market\" \n" +
                "(Damascus radio, 10 March)--a recurrent theme in Syrian media in \n" +
                "recent months (for example, a Tishrin editorial, as reported by \n" +
                "Damascus radio on 8 February). \n" +
                "\n" +
                "   Even Syria's choice of personalities to greet the delegation on \n" +
                "arrival at the airport was clearly meant as a statement: Khalid \n" +
                "al-Fahum, head of a Syrian-backed umbrella group of Palestinian \n" +
                "rejectionists opposed to the PLO, was the only figure reported to \n" +
                "accompany the governor of Damascus to the airport (Damascus \n" +
                "radio, 7 March).  The Syrians thus created the appearance of an \n" +
                "affinity between Israeli Arabs and Palestinians supported by \n" +
                "Damascus, while giving the PLO--still scorned by the Syrians \n" +
                "because of the 13 September Israeli-PLO declaration of \n" +
                "Principles--a symbolic jab. \n" +
                "\n" +
                "   1Qunaytirah was captured by Israel in 1967 and returned to Syria \n" +
                "in ruins following the conclusion of a disengagement of forces \n" +
                "agreement in 1974. \n" +
                "\n" +
                "   Al-Asad Uses Visit for Peace Message \n" +
                "\n" +
                "   While the visitors were used as channels for extolling Syrian \n" +
                "policies, the visit also afforded Damascus an opportunity to send \n" +
                "some signals on the peace process for foreign--particularly U.S. \n" +
                "and Israeli--consumption.  Al-Asad used his meeting with the \n" +
                "delegation as a platform for his first policy statement since the \n" +
                "death of his son.  While breaking no new ground, al-Asad stressed \n" +
                "Syria's commitment to peace, at times echoing his now famous \n" +
                "\"peace of the brave\" speech to the 1992 Druze delegation \n" +
                "(Damascus radio, 9 September 1992).  He told the Israeli Arabs: \n" +
                "\"We seriously seek peace, and the Israeli officials know this,\" \n" +
                "adding, \"In light of what they [Israel] are proposing, it seems \n" +
                "that their vision of peace is not the same as ours.  Therefore, \n" +
                "we will struggle until their peace becomes identical with our \n" +
                "peace . . . . Peace means rights.  In other words, each party has \n" +
                "its rights and each party is the master of itself and its \n" +
                "interests . . . . When we said the peace of the brave, we meant \n" +
                "that each party will achieve full peace with all its rights, and \n" +
                "that neither party will humiliate the other.\" \n" +
                "\n" +
                "   A Limited Opening to Israel \n" +
                "\n" +
                "   The visit itself marked a symbolic though limited advance in \n" +
                "Syrian willingness to take small steps toward opening contacts \n" +
                "with Israel.  It follows such modest advances as an evidently \n" +
                "officially sanctioned series of meetings outside the Middle East \n" +
                "between Syrian and Israeli academics reported by Israeli and \n" +
                "international media (for example, Jerusalem Qol Yisra'el, 31 \n" +
                "December 1993; Yedi'ot Aharonot, 2 January 1994), and the 1992 \n" +
                "visit by the Druze delegation, which crossed into Syria directly \n" +
                "from the Golan Heights and--according to Israeli Prime Minister \n" +
                "Yitzhaq Rabin--included some Israeli passport holders (Jerusalem \n" +
                "Qol Yisra'el, 1 September 1992; Tel Aviv Bamahane, 23 September \n" +
                "1992, respectively).  The fact that Darawshah and al-Sani' are \n" +
                "not only Israeli citizens but also members of Knesset made the \n" +
                "symbolism of the visit still more salient.  In addition, coverage \n" +
                "of the visit for Israel radio by Israeli Arab correspondents who \n" +
                "filed a series of live dispatches from Damascus was another \n" +
                "unprecedented event. \n" +
                "\n" +
                "   Damascus took pains to prevent the visit from appearing as a \n" +
                "precedent for normalization with Israel but nonetheless allowed \n" +
                "the visit's symbolism to be clearly conveyed to the Syrian \n" +
                "public.  On the one hand, delegation members were forced to \n" +
                "travel to Syria via Cairo rather than directly from Israel and \n" +
                "were barred from using Israeli passports (Cairo MENA, 7 March, \n" +
                "Qol Yisra'el, 1O March).  In addition, Syrian media--and even \n" +
                "the delegation members--avoided any explicit reference to the \n" +
                "group's citizenship, referring to the visitors repeatedly as \n" +
                "\"1948 Palestinians.\"  On the other hand, the political status of \n" +
                "the delegation members was made perfectly clear on Syrian media. \n" +
                "For example, Darawshah was quoted by the official Syrian news \n" +
                "service SANA as saying on arrival in Damascus:  \"We represent the \n" +
                "Palestinians in the Galilee, in the Negev, and other cities\" (7 \n" +
                "March).   Moreover, Syrian media's airing of remarks by Darawshah \n" +
                "even made it clear that he is a Knesset member.  For example, \n" +
                "after calling in a Damascus television interview for Israeli \n" +
                "withdrawal from all the occupied territories, Darawshah declared: \n" +
                "\"We say this from Damascus, and we also say the same thing in the \n" +
                "Knesset in Jerusalem.\" \n" +
                "\n" +
                "   The visit also brought somewhat greater openness in Syrian \n" +
                "media's treatment of Israel, as Darawshah was permitted to use \n" +
                "Syrian television to convey an unusually detailed and relatively \n" +
                "sympathetic portrayal of the Israeli government, the internal \n" +
                "Israeli political situation, and Israeli public opinion.  After \n" +
                "calling in his televised address for an Israeli commitment to \n" +
                "withdraw from the occupied territories, Darawshah asserted that \n" +
                "\"of late, many people in Israel have begun to express stands \n" +
                "supportive of this formula\" and that their numbers are \n" +
                "\"increasing.\"  In his 1O March television interview, Darawshah \n" +
                "depicted the government as interested in making further \n" +
                "concessions but constrained by domestic political factors.  He \n" +
                "noted that the current Israeli coalition government \"is supported \n" +
                "by the Arab parties\" and that an expanded coalition \"would enable \n" +
                "the government to continue the peace process and to make \n" +
                "concessions that will respond to the true Arab demands.\"  He also \n" +
                "described what he said was \"a rational trend\" in Israel that is \n" +
                "\"strong indeed\" and which believes that \"we must end occupation.\" \n" +
                "He observed that \"the demonstrations staged by tens of thousands \n" +
                "of people\" in the wake of the Hebron massacre \"was a joint \n" +
                "demonstration by the Arab and Jewish pro-peace forces,\" adding \n" +
                "that \"we participated in it.\" \n" +
                "\n" +
                "   Although the Syrian television host openly took issue with some \n" +
                "of Darawshah's remarks--such as the notion that there are doves \n" +
                "in Israel--the visitor's overall message was evidently agreed on \n" +
                "in advance, as suggested by the manner in which the interviewer \n" +
                "appeared to pave the way for Darawshah's comments.  For example, \n" +
                "he asked Darawshah, \"What is new in Zionist thought and \n" +
                "direction?\" \n" +
                "\n" +
                "   Further Visits? \n" +
                "\n" +
                "   The delegation's visit has prompted reports in Israeli media that \n" +
                "there will be future visits to Syria by other Israeli citizens, \n" +
                "but there have been no such reports in Syrian media.  Evidently \n" +
                "based on comments by an Israeli Arab journalist who was part of \n" +
                "the delegation, Qol Yisra'el reported that Foreign Minister Faruq \n" +
                "al-Shar' had told the group the delegation's visit \"is an opening \n" +
                "for additional visits to Syria by Israelis\" (11 March).  Ool \n" +
                "Yisra'el reported the same day that a delegation led by Ibrahim \n" +
                "Nimr Husayn, chairman of Israel's National Committee of Arab \n" +
                "Local Councils, and Ahmad al-Tibi, an Israeli citizen and adviser \n" +
                "to PLO chief Yasir 'Arafat--\"may soon leave for Syria.\"  Another \n" +
                "Qol Yisra'el report claimed that a 170-member delegation of Golan \n" +
                "Druze was being permitted by Israel to visit Damascus to extend \n" +
                "condolences to al-Asad on his son's death, but that the Syrians \n" +
                "had not yet approved the visit (15 March). \n" +
                "\n" +
                "   Implications \n" +
                "\n" +
                "   The very fact that Darawshah 8.4 tons was given a forum for his more \n" +
                "favorable statements on Israel suggests that Syria wants the \n" +
                "visit to be seen as a significant indication of a genuine Syrian \n" +
                "openness to peace with Israel and as meeting Israeli demands that \n" +
                "such openness be conveyed more clearly to the Syrian public.  Now \n" +
                "that the barrier to visits by Israeli Arabs has been lifted, \n" +
                "there may well be more such visits.  But, considering Syrian \n" +
                "sensitivity over even the 500 million pounds appearance of normalizing relations \n" +
                "with the Jewish state, and given Syria's repeated objections to \n" +
                "Israeli demands for 50.32 million pounds a commitment to such normalization in the \n" +
                "future, similar visits by Jewish citizens of Israel are probably \n" +
                "not imminent. \n" +
                "   (AUTHOR:  BROWN.  QUESTIONS AND/OR COMMENTS, PLEASE CALL CHIEF, \n" +
                "NEAR EAST ANALYSIS BRANCH (703) 733-6094.) \n" +
                "CB 16/2120z Mar ";
    }

}
