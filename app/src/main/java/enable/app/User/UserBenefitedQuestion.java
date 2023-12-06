package enable.app.User;

import java.util.ArrayList;
import java.util.List;

public class UserBenefitedQuestion {

    public enum InputType{
        Spinner,
        EditText,
        Date,
        Number,
        Img,
        Radio
    }

    public UserBenefitedQuestion() {
        if (Questions == null) {
            Questions = new ArrayList<Question>();
            Question question0 = new Question();
            question0.Id = 0;
            question0.Text = "Olá, tudo bom ?, primeiro gostaria de saber o seu nome.";
            question0.Hint = "Informe o seu nome";
            question0.Requarid = true;
            question0.Column = "name";
            question0.InputType = InputType.EditText;
            Questions.add(question0);

            Question question1 = new Question();
            question1.Id = 1;
            question1.Text = "Olá 'n', bem vindo a e-NABLE Brasil, agora gostariamos de saber o seu e-mail.";
            question1.Hint = "Informe o seu e-mail";
            question1.Requarid = true;
            question1.Column = "email";
            question1.InputType = InputType.EditText;
            Questions.add(question1);

            Question question2 = new Question();
            question2.Id = 2;
            question2.Text = "Olá 'n', precisamos saber qual o estado que você mora.";
            question2.Hint = "Informe o estado que você mora";
            question2.Requarid = true;
            question2.Column = "state";
            question2.InputType = InputType.Spinner;
            question2.Options = new ArrayList<String>();
            question2.Options.add("Selecione o estado...");
            question2.Options.add("Acre");
            question2.Options.add("Alagoas");
            question2.Options.add("Amazonas");
            question2.Options.add("Bahia");
            question2.Options.add("Ceará");
            question2.Options.add("Goiás");
            question2.Options.add("Espírito Santo");
            question2.Options.add("Maranhão");
            question2.Options.add("Mato Grosso");
            question2.Options.add("Mato Grosso do Sul");
            question2.Options.add("Minas Gerais");
            question2.Options.add("Pará");
            question2.Options.add("Paraná");
            question2.Options.add("Pernambuco");
            question2.Options.add("Piauí");
            question2.Options.add("Rio de Janeiro");
            question2.Options.add("Rio Grande do Norte");
            question2.Options.add("Rio Grande do Sul");
            question2.Options.add("Rondônia");
            question2.Options.add("Roraima");
            question2.Options.add("Santa Catarina");
            question2.Options.add("São Paulo");
            question2.Options.add("Sergipe");
            question2.Options.add("Tocantins");
            question2.Options.add("Distrito Federal");
            Questions.add(question2);

            Question question3 = new Question();
            question3.Id = 3;
            question3.Text = "Olá 'n', precisamos saber qual a cidade que você mora.";
            question3.Hint = "Informe a cidade que você mora";
            question3.Requarid = true;
            question3.Column = "city";
            question3.InputType = InputType.EditText;
            Questions.add(question3);

            Question question4 = new Question();
            question4.Id = 4;
            question4.Text = "Olá 'n', agora gostariámos de saber para quem será a prótese.";
            question4.Requarid = true;
            question4.Column = "ProsthesisReceptor";
            question4.Hint = "Selecione para quem será a prótese";
            question4.InputType = InputType.Radio;
            question4.Options = new ArrayList<String>();
            question4.Options.add("Para mim");
            question4.Options.add("outra pessoa");
            Questions.add(question4);

            Question question5 = new Question();
            question5.Id = 5;
            question5.Text = "Olá 'n', a diferença de membros  foi causada por amputação ou é uma condição de nascença?";
            question5.Requarid = true;
            question5.Column = "CausedInvestigation";
            question5.Hint = "Selecione a opção sim ou não";
            question5.InputType = InputType.Radio;
            question5.Options = new ArrayList<String>();
            question5.Options.add("Amputação");
            question5.Options.add("Condição de Nascença");
            Questions.add(question5);

            Question question6 = new Question();
            question6.Id = 6;
            question6.Text = "Olá 'n', Caso seja amputação, a quanto tempo ocorreu a amputação em meses? \n\nDigite zero caso não ocorreu amputação.";
            question6.Hint = "Informe e tempo de amputação em meses";
            question6.Requarid = false;
            question6.Column = "AmputationTimeMonths";
            question6.InputType = InputType.Number;
            Questions.add(question6);

            Question question7 = new Question();
            question7.Id = 7;
            question7.Text = "Olá 'n', precisamos saber a sua data de nascimento do receptor da prótese.";
            question7.Hint = "Informe a sua data de nascimento";
            question7.Requarid = true;
            question7.Column = "birthdate";
            question7.InputType = InputType.Date;
            Questions.add(question7);

            Question question8 = new Question();
            question8.Id = 8;
            question8.Text = "Olá 'n', qual o seu telefone com DDD?";
            question8.Hint = "Informe o telefone com o DDD";
            question8.Requarid = true;
            question8.Column = "phone";
            question8.InputType = InputType.Number;
            Questions.add(question8);

            Question question9 = new Question();
            question9.Id = 9;
            question9.Text = "Olá 'n', Em qual braço você necessita de uma prótese?";
            question9.Requarid = true;
            question9.Column = "arm";
            question9.Hint = "Selecione o membro";
            question9.InputType = InputType.Spinner;
            question9.Options = new ArrayList<String>();
            question9.Options.add("Selecione a opção...");
            question9.Options.add("Esquerdo");
            question9.Options.add("Direito");
            question9.Options.add("Esquerdo e Direito");
            Questions.add(question9);

            Question question10 = new Question();
            question10.Id = 10;
            question10.Text = "Olá 'n', Até que nível seu membro foi acometido?";
            question10.Requarid = true;
            question10.Column = "deficiency";
            question10.Hint = "Selecione o tipo de diferença ";
            question10.InputType = InputType.Img;
            question10.Options = new ArrayList<String>();
            question10.Options.add("Selecione a opção...");
            question10.Options.add("Transumeral");
            question10.Options.add("Transradial");
            question10.Options.add("Sem pulso");
            question10.Options.add("Mão Parcial");
            question10.Options.add("Dedo parcial");
            question10.Options.add("Outro");
            Questions.add(question10);

            Question question11 = new Question();
            question11.Id = 11;
            question11.Text = "Olá 'n', precisamos que você leia com atenção esse termo. \n\nNo Brasil, próteses devem ser prescritas por um profissional de saúde e seu uso deve ser acompanhado por um profissional da área de reabilitação. Você tem acesso a um profissional de saúde que possa avaliar sua amputação e emitir a prescrição de prótese? (a doação da prótese só pode acontecer mediante prescrição de prótese expedida por um profissional de saúde devidamente habilitado)";
            question11.Requarid = true;
            question11.Column = "termprofessionalhealth";
            question11.Hint = "Selecione um termo de aceite";
            question11.InputType = InputType.Radio;
            question11.Options = new ArrayList<String>();
            question11.Options.add("Sim. Eu sou atendido ou tenho acesso a um profissional de saúde que pode fazer a solicitação de prótese.");
            question11.Options.add("Eu não sou atendido mas tenho acesso a um profissional de saúde para fazer a prescrição de prótese.");
            question11.Options.add("Eu não sou atendido nem tenho acesso a um profissional de saúde.");
            Questions.add(question11);

            Question question12 = new Question();
            question12.Id = 12;
            question12.Text = "Olá 'n', precisamos que você leia com atenção esse termo. \n\nAs próteses da e-NABLE são registradas e sua comercialização é proibida por lei. Ao aceitar estes termos você se compromete a não comercializar, doar ou repassar para terceiros a prótese e-NABLE que venha a receber.";
            question12.Requarid = true;
            question12.Column = "TermMarketingProstheses";
            question12.Hint = "Selecione o termo de aceite";
            question12.InputType = InputType.Radio;
            question12.Options = new ArrayList<String>();
            question12.Options.add("Declaro que estou ciente que a comercialização destas próteses é proibida por lei e que estou solicitando esta prótese para uso pessoal.");
            Questions.add(question12);

            //Question question2 = new Question();
            //question2.Id = 2;
            //question2.Photo = true;
            //Questions.add(question2);
        }
    }

    public Question getQuestion(int index) {
        Question questionName = Questions.get(0);
        if (index < Questions.size()) {
            Question question = Questions.get(index);
            if (questionName.Value != null) {
                if (question.Text != null){
                    question.Text = question.Text.replace("'n'", questionName.Value);
                }
            }
            return question;
        }
        return null;
    }

    public class Question {
        public int Id;
        public String Text;
        public String Value;
        public String Hint;
        public boolean Requarid;
        public boolean Photo;
        public  String Column;
        public  InputType InputType;
        public  List<String> Options;
    }

    public static List<Question> Questions;
}
