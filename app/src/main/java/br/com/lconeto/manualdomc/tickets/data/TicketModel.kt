package br.com.lconeto.manualdomc.tickets.data

object TicketModel {

    fun getStringFromAuthModel(
        chapter: String,
        chapterNumber: Int,
        store: String,
        storeNumber: Int,
        day: String,
        hour: String,
        packageId: String,
        mcName: String
    ): String {
        return """
            Olá,
            
            Gostaria de solicitar a autorização para concessão Grau Iniciático/DeMolay ou Cerimônia de Instalação realizada Capítulo $chapter n° $chapterNumber que ocorrerá na Loja $store n° $storeNumber no dia $day às $hour, conforme o pacote nº $packageId.
            Segue comprovante do pagamento do pacote. Ficamos à disposição para fornecer qualquer documentação adicional ou esclarecimentos necessários para a aprovação desta solicitação.
            
            Atenciosamente,
            $mcName - Mestre Conselheiro
        """.trimIndent()
    }

    fun getStringFromEmailModel(
        chapter: String,
        chapterNumber: Int,
        name: String,
        id: Int,
        email: String,
        mcName: String
    ): String {
        return """
            Olá!
            
            Gostaria de solicitar a alteração de E-mail de um membro do Capitulo $chapter n° $chapterNumber para que ele possa ter acesso ao sisdm
            
            Nome: $name
            ID: $id
            E-mail certo: $email
            
            Certo de vossa atenção agradeço desde já!
            
            Atenciosamente,
            $mcName - Mestre Conselheiro
        """.trimIndent()
    }
}
