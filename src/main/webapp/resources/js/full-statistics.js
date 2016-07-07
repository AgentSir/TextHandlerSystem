var filesStatistics;
var handledTextStatistics;

function getListOfStatistics() {
    $('#show-all-files-statistics').prop("disabled", true);
    $.ajax({
        type: 'GET',
        url: '/files',
        success: function (statistics) {
            if (statistics) {
                filesStatistics = statistics;
                renderStatistics(statistics);
            }
        },
    }).always(function () {
        $('#show-all-files-statistics').prop("disabled", false);
    });
}

function getListOfStatisticsByCriteria(criteria) {
    $('#search-files').prop("disabled", true);
    $.ajax({
        type: 'GET',
        url: '/search/files/' + criteria,
        success: function (statisticsByCriteria) {
            if (statisticsByCriteria) {
                filesStatistics = statisticsByCriteria;
                renderStatistics(statisticsByCriteria);
            }
        },
    }).always(function () {
        $('#search-files').prop("disabled", false);
    });
}

function handleText(text) {
    var requestData = {"text": text};
    $('#handle-text').prop("disabled", true);
    $.ajax({
        type: 'POST',
        url: '/text/processText/',
        contentType: 'application/json',
        data: JSON.stringify(requestData),
        success: function (statisticsOfHandledText) {
            if (statisticsOfHandledText) {
                handledTextStatistics = statisticsOfHandledText;
                renderStatisticsOfText(statisticsOfHandledText);
            }
        },
    }).always(function () {
        $('#handle-text').prop("disabled", false);
    });
}

function renderStatistics(statistics) {
    $("#files-statistics > tbody").html(""); 
    for (var i = 0; i < statistics.length; i++) {
        var row = $("<tr />")
        $("#files-statistics").append(row); 
        row.append($("<td>" + statistics[i].name + "</td>"));
        row.append($("<td>" + statistics[i].longestWord + "</td>"));
        row.append($("<td>" + statistics[i].smallestWord + "</td>"));
        row.append($("<td>" + statistics[i].length + "</td>"));
        row.append($("<td>" + statistics[i].avgWordLength + "</td>"));
    }
}

function renderStatisticsOfText(statistics) {
    $("#files-statistics > tbody").html(""); 
    var row = $("<tr />");
    $("#files-statistics").append(row); 
    row.append($("<td>" + statistics.longestWord + "</td>"));
    row.append($("<td>" + statistics.smallestWord + "</td>"));
    row.append($("<td>" + statistics.length + "</td>"));
    row.append($("<td>" + statistics.avgWordLength + "</td>"));
}

function renderInternalStatistics(files_statistics, file_name, file_id) {
    // include a name of file into title of the modal dialog
    $("#lines-modal-dialog").find(".modal-title").text(file_name);
    $("#file-internal-statistics > tbody").html(""); 
    for (var i = 0; i < files_statistics[file_id].lines.length; i++) {
        var row = $("<tr />")
        $("#file-internal-statistics").append(row); 
        row.append($("<td>" + files_statistics[file_id].lines[i].lineNumber + "</td>"));
        row.append($("<td>" + files_statistics[file_id].lines[i].longestWord + "</td>"));
        row.append($("<td>" + files_statistics[file_id].lines[i].smallestWord + "</td>"));
        row.append($("<td>" + files_statistics[file_id].lines[i].length + "</td>"));
        row.append($("<td>" + files_statistics[file_id].lines[i].avgWordLength + "</td>"));
    }
}

function renderInternalStatisticsOfText(text_statistics) {
    $("#file-internal-statistics > tbody").html(""); 
    for (var i = 0; i < text_statistics.lines.length; i++) {
        var row = $("<tr />")
        $("#file-internal-statistics").append(row); 
        row.append($("<td>" + text_statistics.lines[i].lineNumber + "</td>"));
        row.append($("<td>" + text_statistics.lines[i].longestWord + "</td>"));
        row.append($("<td>" + text_statistics.lines[i].smallestWord + "</td>"));
        row.append($("<td>" + text_statistics.lines[i].length + "</td>"));
        row.append($("<td>" + text_statistics.lines[i].avgWordLength + "</td>"));
    }
}

$(document).ready(function () {
    $('#files-statistics').hide();
    
    $('#search-files').click(function () {
        getListOfStatisticsByCriteria($('#min-count-lines').val());
        $('#files-statistics').show();
    });
    
    $('#handle-text').click(function () {
        handleText($('#text-for-handle').val());
        $('#files-statistics').show();
    });
    
    $('#show-all-files-statistics').click(function () {
        getListOfStatistics()
        $('#files-statistics').show();
    });
    
    $('#files-statistics').find("#fs-tbody").on('click', 'tr', function () {
        var row_id = $(this).index();
        var file_name;
        if(handledTextStatistics == null) {
            file_name = filesStatistics[row_id].name;
            $("#lines-modal-dialog").modal('show');
            renderInternalStatistics(filesStatistics, file_name, row_id)
        } else {
            $("#lines-modal-dialog").modal('show');
            renderInternalStatisticsOfText(handledTextStatistics);
        }
    });
});

