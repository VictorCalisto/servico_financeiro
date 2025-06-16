// Interface para simulações financeiras
interface SimulavelFinanceiramente {
    double simularAjusteUrgencia(int novaUrgencia);

    double simularDesconto(double percentualDesconto);
}

// Classe abstrata que representa um serviço profissional
abstract class ServicoProfissional implements SimulavelFinanceiramente {

    private static final double COMPLEXITY_FACTOR_MULTIPLIER = 0.1;
    private static final double URGENCY_FACTOR_MULTIPLIER = 0.05;
    private static final int MIN_LEVEL = 1;
    private static final int MAX_LEVEL = 5;

    protected String descricao;
    protected double horasEstimadas;
    protected int complexidade;
    protected int urgencia;
    protected double valorHoraBase;

    public ServicoProfissional(String descricao, double horasEstimadas, int complexidade, int urgencia,
            double valorHoraBase) {
        this.descricao = descricao;
        this.horasEstimadas = horasEstimadas;
        this.complexidade = Math.max(MIN_LEVEL, Math.min(MAX_LEVEL, complexidade));
        this.urgencia = Math.max(MIN_LEVEL, Math.min(MAX_LEVEL, urgencia));
        this.valorHoraBase = valorHoraBase;
    }

    public abstract double calcularPrecoFinal();

    public abstract void detalharComposicaoCusto();

    protected double calcularFatorComplexidade() {
        return 1 + (complexidade * COMPLEXITY_FACTOR_MULTIPLIER);
    }

    protected double calcularFatorUrgencia(int urgenciaParam) {
        return 1 + (urgenciaParam * URGENCY_FACTOR_MULTIPLIER);
    }

    @Override
    public double simularAjusteUrgencia(int novaUrgencia) {
        int urgenciaOriginal = this.urgencia;
        this.urgencia = Math.max(MIN_LEVEL, Math.min(MAX_LEVEL, novaUrgencia));
        double precoSimulado = calcularPrecoFinal();
        this.urgencia = urgenciaOriginal; // Restaura a urgência original após a simulação
        return precoSimulado;
    }

    @Override
    public double simularDesconto(double percentualDesconto) {
        double preco = calcularPrecoFinal();
        return preco * (1 - (percentualDesconto / 100.0));
    }
}

// Classe concreta para Projeto de Engenharia
class ProjetoEngenharia extends ServicoProfissional {

    public ProjetoEngenharia(String descricao, double horasEstimadas, int complexidade, int urgencia,
            double valorHoraBase) {
        super(descricao, horasEstimadas, complexidade, urgencia, valorHoraBase);
    }

    @Override
    public double calcularPrecoFinal() {
        return valorHoraBase * horasEstimadas * calcularFatorComplexidade() * calcularFatorUrgencia(this.urgencia);
    }

    @Override
    public void detalharComposicaoCusto() {
        System.out.println("===== Detalhamento do Custo - Projeto de Engenharia =====");
        System.out.println("Descrição: " + descricao);
        System.out.println("Valor Hora Base: R$ " + String.format("%.2f", valorHoraBase));
        System.out.println("Horas Estimadas: " + String.format("%.2f", horasEstimadas));
        System.out.println("Complexidade: " + complexidade + " (Fator: "
                + String.format("%.2f", calcularFatorComplexidade()) + ")");
        System.out.println("Urgência: " + urgencia + " (Fator: "
                + String.format("%.2f", calcularFatorUrgencia(this.urgencia)) + ")");
        System.out.println("Preço Final: R$ " + String.format("%.2f", calcularPrecoFinal()));
        System.out.println("=========================================================");
    }
}

// Classe concreta para Análise Tecnológica
class AnaliseTecnologica extends ServicoProfissional {

    public AnaliseTecnologica(String descricao, double horasEstimadas, int complexidade, int urgencia,
            double valorHoraBase) {
        super(descricao, horasEstimadas, complexidade, urgencia, valorHoraBase);
    }

    @Override
    public double calcularPrecoFinal() {
        return valorHoraBase * horasEstimadas * calcularFatorComplexidade() * calcularFatorUrgencia(this.urgencia);
    }

    @Override
    public void detalharComposicaoCusto() {
        System.out.println("===== Detalhamento do Custo - Análise Tecnológica =====");
        System.out.println("Descrição: " + descricao);
        System.out.println("Valor Hora Base: R$ " + String.format("%.2f", valorHoraBase));
        System.out.println("Horas Estimadas: " + String.format("%.2f", horasEstimadas));
        System.out.println("Complexidade: " + complexidade + " (Fator: "
                + String.format("%.2f", calcularFatorComplexidade()) + ")");
        System.out.println("Urgência: " + urgencia + " (Fator: "
                + String.format("%.2f", calcularFatorUrgencia(this.urgencia)) + ")");
        System.out.println("Preço Final: R$ " + String.format("%.2f", calcularPrecoFinal()));
        System.out.println("=======================================================");
    }
}

// Classe concreta para Consultoria Legal
class ConsultoriaLegal extends ServicoProfissional {

    public ConsultoriaLegal(String descricao, double horasEstimadas, int complexidade, int urgencia,
            double valorHoraBase) {
        super(descricao, horasEstimadas, complexidade, urgencia, valorHoraBase);
    }

    @Override
    public double calcularPrecoFinal() {
        return valorHoraBase * horasEstimadas * calcularFatorComplexidade() * calcularFatorUrgencia(this.urgencia);
    }

    @Override
    public void detalharComposicaoCusto() {
        System.out.println("===== Detalhamento do Custo - Consultoria Legal =====");
        System.out.println("Descrição: " + descricao);
        System.out.println("Valor Hora Base: R$ " + String.format("%.2f", valorHoraBase));
        System.out.println("Horas Estimadas: " + String.format("%.2f", horasEstimadas));
        System.out.println("Complexidade: " + complexidade + " (Fator: "
                + String.format("%.2f", calcularFatorComplexidade()) + ")");
        System.out.println("Urgência: " + urgencia + " (Fator: "
                + String.format("%.2f", calcularFatorUrgencia(this.urgencia)) + ")");
        System.out.println("Preço Final: R$ " + String.format("%.2f", calcularPrecoFinal()));
        System.out.println("=====================================================");
    }
}

// Classe principal para teste
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Teste Projeto de Engenharia ---");
        ProjetoEngenharia projetoEngenharia = new ProjetoEngenharia(
                "Projeto Estrutural de Prédio",
                40,
                4,
                3,
                200);

        double precoFinalEngenharia = projetoEngenharia.calcularPrecoFinal();
        System.out.println("Preço Final: R$ " + String.format("%.2f", precoFinalEngenharia));

        double precoComDescontoEngenharia = projetoEngenharia.simularDesconto(10);
        System.out.println("Preço com 10% de desconto: R$ " + String.format("%.2f", precoComDescontoEngenharia));

        double precoComUrgenciaMaximaEngenharia = projetoEngenharia.simularAjusteUrgencia(5);
        System.out.println(
                "Preço com urgência máxima (5): R$ " + String.format("%.2f", precoComUrgenciaMaximaEngenharia));

        projetoEngenharia.detalharComposicaoCusto();

        System.out.println("\n--- Teste Análise Tecnológica ---");
        AnaliseTecnologica analiseTecnologica = new AnaliseTecnologica(
                "Análise de Segurança de Rede",
                80,
                5,
                4,
                150);
        System.out.println("Preço Final: R$ " + String.format("%.2f", analiseTecnologica.calcularPrecoFinal()));
        System.out.println(
                "Preço com 5% de desconto: R$ " + String.format("%.2f", analiseTecnologica.simularDesconto(5)));
        System.out.println(
                "Preço com urgência 2: R$ " + String.format("%.2f", analiseTecnologica.simularAjusteUrgencia(2)));
        analiseTecnologica.detalharComposicaoCusto();

        System.out.println("\n--- Teste Consultoria Legal ---");
        ConsultoriaLegal consultoriaLegal = new ConsultoriaLegal(
                "Elaboração de Contrato Societário",
                25,
                3,
                5,
                300);
        System.out.println("Preço Final: R$ " + String.format("%.2f", consultoriaLegal.calcularPrecoFinal()));
        System.out.println(
                "Preço com 15% de desconto: R$ " + String.format("%.2f", consultoriaLegal.simularDesconto(15)));
        System.out.println(
                "Preço com urgência 1: R$ " + String.format("%.2f", consultoriaLegal.simularAjusteUrgencia(1)));
        consultoriaLegal.detalharComposicaoCusto();
    }
}
