public class roles {
    public static void main(String[] args) {
        String [] roles = {
        "Городничий","Аммос Федорович",
        "Артемий Филиппович",
        "Лука Лукич"};
        String [] textLines = {
        "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
        "Аммос Федорович: Как ревизор?",
        "Артемий Филиппович: Как ревизор?",
        "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
        "Аммос Федорович: Вот те на!",
        "Артемий Филиппович: Вот не было заботы, так подай!",
        "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

        System.out.println(printTextPerRole(roles, textLines));
    }

    
    //Метод для группировки и нумерации строк в сценарии пьесы по ролям
    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder sbTextPerRole = new StringBuilder();
        StringBuilder sbText = new StringBuilder();
        StringBuilder sbRole = new StringBuilder();

        for (String role : roles) {
            sbRole.append(role).append(":");
            sbTextPerRole.append(sbRole).append("\n");
            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].startsWith(sbRole.toString())) {
                    textLines[i] = textLines[i].replaceFirst(sbRole.toString(), "");
                    sbText.append(i + 1).append(")").append(textLines[i]);
                    sbTextPerRole.append(sbText).append("\n");
                    sbText.setLength(0);
                }
            }
            sbTextPerRole.append("\n");
            sbRole.setLength(0);
        }

        return sbTextPerRole.toString();
    }
}
