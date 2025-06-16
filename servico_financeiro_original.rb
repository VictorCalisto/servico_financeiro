#!/usr/bin/env ruby

# frozen_string_literal: true

module SimulavelFinanceiramente
  def simular_ajuste_urgencia(nova_urgencia); end

  def simular_desconto(percentual_desconto); end
end

class ServicoProfissional
  include SimulavelFinanceiramente

  COMPLEXITY_FACTOR_MULTIPLIER = 0.1
  URGENCY_FACTOR_MULTIPLIER = 0.05
  MIN_LEVEL = 1
  MAX_LEVEL = 5

  attr_accessor :descricao, :horas_estimadas, :complexidade, :urgencia, :valor_hora_base

  def initialize(descricao, horas_estimadas, complexidade, urgencia, valor_hora_base)
    @descricao = descricao
    @horas_estimadas = horas_estimadas
    @complexidade = [MIN_LEVEL, MAX_LEVEL, complexidade].sort[1]
    @urgencia = [MIN_LEVEL, MAX_LEVEL, urgencia].sort[1]
    @valor_hora_base = valor_hora_base
  end

  def calcular_preco_final
    raise NotImplementedError, "#{self.class} deve implementar o método 'calcular_preco_final'"
  end

  def detalhar_composicao_custo
    raise NotImplementedError, "#{self.class} deve implementar o método 'detalhar_composicao_custo'"
  end

  protected

  def calcular_fator_complexidade
    1 + (complexidade * COMPLEXITY_FACTOR_MULTIPLIER)
  end

  def calcular_fator_urgencia(urgencia_param)
    1 + (urgencia_param * URGENCY_FACTOR_MULTIPLIER)
  end

  public

  def simular_ajuste_urgencia(nova_urgencia)
    urgencia_original = @urgencia
    @urgencia = [MIN_LEVEL, MAX_LEVEL, nova_urgencia].sort[1]
    preco_simulado = calcular_preco_final
    @urgencia = urgencia_original
    preco_simulado
  end

  def simular_desconto(percentual_desconto)
    preco = calcular_preco_final
    preco * (1 - (percentual_desconto / 100.0))
  end
end

class ProjetoEngenharia < ServicoProfissional
  def calcular_preco_final
    @valor_hora_base * @horas_estimadas * calcular_fator_complexidade * calcular_fator_urgencia(@urgencia)
  end

  def detalhar_composicao_custo
    puts '===== Detalhamento do Custo - Projeto de Engenharia ====='
    puts "Descrição: #{@descricao}"
    puts "Valor Hora Base: R$ #{format('%.2f', @valor_hora_base)}"
    puts "Horas Estimadas: #{format('%.2f', @horas_estimadas)}"
    puts "Complexidade: #{@complexidade} (Fator: #{format('%.2f', calcular_fator_complexidade)})"
    puts "Urgência: #{@urgencia} (Fator: #{format('%.2f', calcular_fator_urgencia(@urgencia))})"
    puts "Preço Final: R$ #{format('%.2f', calcular_preco_final)}"
    puts '========================================================='
  end
end

class AnaliseTecnologica < ServicoProfissional
  def calcular_preco_final
    @valor_hora_base * @horas_estimadas * calcular_fator_complexidade * calcular_fator_urgencia(@urgencia)
  end

  def detalhar_composicao_custo
    puts '===== Detalhamento do Custo - Análise Tecnológica ====='
    puts "Descrição: #{@descricao}"
    puts "Valor Hora Base: R$ #{format('%.2f', @valor_hora_base)}"
    puts "Horas Estimadas: #{format('%.2f', @horas_estimadas)}"
    puts "Complexidade: #{@complexidade} (Fator: #{format('%.2f', calcular_fator_complexidade)})"
    puts "Urgência: #{@urgencia} (Fator: #{format('%.2f', calcular_fator_urgencia(@urgencia))})"
    puts "Preço Final: R$ #{format('%.2f', calcular_preco_final)}"
    puts '======================================================='
  end
end

class ConsultoriaLegal < ServicoProfissional
  def calcular_preco_final
    @valor_hora_base * @horas_estimadas * calcular_fator_complexidade * calcular_fator_urgencia(@urgencia)
  end

  def detalhar_composicao_custo
    puts '===== Detalhamento do Custo - Consultoria Legal ====='
    puts "Descrição: #{@descricao}"
    puts "Valor Hora Base: R$ #{format('%.2f', @valor_hora_base)}"
    puts "Horas Estimadas: #{format('%.2f', @horas_estimadas)}"
    puts "Complexidade: #{@complexidade} (Fator: #{format('%.2f', calcular_fator_complexidade)})"
    puts "Urgência: #{@urgencia} (Fator: #{format('%.2f', calcular_fator_urgencia(@urgencia))})"
    puts "Preço Final: R$ #{format('%.2f', calcular_preco_final)}"
    puts '====================================================='
  end
end

class Main
  def self.main
    puts '--- Teste Projeto de Engenharia ---'
    projeto_engenharia = ProjetoEngenharia.new(
      'Projeto Estrutural de Prédio',
      40,
      4,
      3,
      200
    )

    preco_final_engenharia = projeto_engenharia.calcular_preco_final
    puts "Preço Final: R$ #{format('%.2f', preco_final_engenharia)}"

    preco_com_desconto_engenharia = projeto_engenharia.simular_desconto(10)
    puts "Preço com 10% de desconto: R$ #{format('%.2f', preco_com_desconto_engenharia)}"

    preco_com_urgencia_maxima_engenharia = projeto_engenharia.simular_ajuste_urgencia(5)
    puts "Preço com urgência máxima (5): R$ #{format('%.2f', preco_com_urgencia_maxima_engenharia)}"

    projeto_engenharia.detalhar_composicao_custo

    puts "\n--- Teste Análise Tecnológica ---"
    analise_tecnologica = AnaliseTecnologica.new(
      'Análise de Segurança de Rede',
      80,
      5,
      4,
      150
    )
    puts "Preço Final: R$ #{format('%.2f', analise_tecnologica.calcular_preco_final)}"
    puts "Preço com 5% de desconto: R$ #{format('%.2f', analise_tecnologica.simular_desconto(5))}"
    puts "Preço com urgência 2: R$ #{format('%.2f', analise_tecnologica.simular_ajuste_urgencia(2))}"
    analise_tecnologica.detalhar_composicao_custo

    puts "\n--- Teste Consultoria Legal ---"
    consultoria_legal = ConsultoriaLegal.new(
      'Elaboração de Contrato Societário',
      25,
      3,
      5,
      300
    )
    puts "Preço Final: R$ #{format('%.2f', consultoria_legal.calcular_preco_final)}"
    puts "Preço com 15% de desconto: R$ #{format('%.2f', consultoria_legal.simular_desconto(15))}"
    puts "Preço com urgência 1: R$ #{format('%.2f', consultoria_legal.simular_ajuste_urgencia(1))}"
    consultoria_legal.detalhar_composicao_custo
  end
end

Main.main
