let consultarVeiculos = (url) => {
    $.ajax({
        type: 'get',
        url: url || 'http://localhost:8080/veiculo',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        crossDomain: true,
        success: (veiculos) => {
            let veiculosStr = '<tr><th>nomeCliente|</th><th>marcaModeloVeiculo|</th>|<th>anoModelo|</th>|<th>valorVenda|</th>|<th>dataPublicacao</th></tr>';
            for (veiculo of veiculos) {
                veiculosStr +=
                    '<tr>' +
                    '<td>' + veiculo.nomeCliente + '</td>' +
                    '<td>' + veiculo.marcaModeloVeiculo + '</td>' +
                    '<td>' + veiculo.anoModelo + '</td>' +
                    '<td>' + veiculo.valorVenda + '</td>' +
                    '<td>' + veiculo.dataPublicacao + '</td>' +
                    '</tr>';
            }
            $('#tabela-veiculos').html(veiculosStr);
        },
        error: (erro) => {
            window.alert("Ocorreu um erro: " + JSON.stringify(erro));
        }
    });
};

$('#btn-buscar').click(() => {
    if ($('#input-buscar').val() == "") {
        consultarVeiculos();
    } else {
        consultarVeiculos('http://localhost:8080/veiculo' + $('#input-buscar').val());
    }
});
