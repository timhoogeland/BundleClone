<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body onload="getAccounts()">

	<jsp:include page="parts/navigation.jsp" />

	<main>
	<div class="welcomeBlock">
		<h1>All Accounts</h1>
		<button class="buttonRound" onclick="toggleHide('helpPopup', false)">?</button>
		<button class="buttonRound" onclick="window.location.href='new_contract.jsp'">+</button>
	</div>

	<div class="block">

		<div id="mainLoader" class="loaderBlock">
        <div class="loader"></div>
    </div>

		<div id="account">
			<table id='accountstable' class='contracts_table'>
				<thead>
					<tr class="desktop">
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Usertype</th>
						<th>Status</th>

					</tr>
				</thead>
				<tbody>
				<tbody>
			</table>
		</div>
	</div>
	</main>

	<jsp:include page="parts/footer.jsp" />
  <script> function getAccounts(){
    var sessionToken = window.sessionStorage.getItem("sessionToken");

    $.ajax({
      url: "/bundlePWABackend/restservices/user",
      type: "get",
      beforeSend: function(xhr) {
        xhr.setRequestHeader("Authorization",  "Bearer " + sessionToken);
      },
      success: function(result) {
        addNotification("Authorized, Accounts loaded!", "green");
        $('#mainLoader').fadeOut('fast');
        var data = result;
        var table = document.getElementById('accountstable');
        data.forEach(function(object) {
          var tr = document.createElement('tr');
          tr.innerHTML = '<td class="id" id="loanid" data-label="ID">'
              + object.userid + '</td>'
              + '<td id ="firstname" data-label="Amount">'
              + object.firstName + '</td>'
              + '<td id = "lastname" data-label="Duration">'
              + object.lastName + '</td>'
              + '<td id = "usertype" data-label="End Date">'
              + object.userType + '</td>'
              + '<td id="status" data-label="Status">'
              + object.status + '</td>'


              + "<td class='tdHide'>  <button class='small' onclick=window.location.href='account.jsp?id=" + object.userid
              + "'>View</button> </td>"
              + "<td class='tdHide'>  <button class='small' onclick=window.location.href='account.jsp?id=" + object.userid
              + "'>Toggle</button> </td>"
          table.appendChild(tr);
        });
      },
      error: function(response, textStatus, errorThrown) {
          addNotification("Unauthorized, loan not loaded!")
          console.log("textStatus: " + textStatus);
          console.log("errorThrown: " + errorThrown);
          console.log("status: " + response.status);
      }
    });
  }</script>

  <div id="helpPopup" class="popup" style="display: none;">
    <div>
      <h2>Contracts explained</h2>
      <button class="buttonRound" onclick="toggleHide('helpPopup', true)">X</button>
      <p>
        Lorem ipsum dolor sit amet, pretium leo sed, ac leo aenean tellus, orci amet maxime amet sed nunc pharetra, scelerisque tristique pretium morbi scelerisque mollis sed, vivamus pede irure ac lacus. Diam ante sit amet, blandit laoreet interdum sem pellentesque. Sit turpis ligula non, iaculis viverra.
        Lorem ipsum dolor sit amet, pretium leo sed, ac leo aenean tellus, orci amet maxime amet sed nunc pharetra, scelerisque tristique pretium morbi scelerisque mollis sed, vivamus pede irure ac lacus. Diam ante sit amet, blandit laoreet interdum sem pellentesque. Sit turpis ligula non, iaculis viverra.
      </p>
    </div>
  </div>

</body>
</html>
