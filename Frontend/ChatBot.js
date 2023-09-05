document.addEventListener("DOMContentLoaded", function() {
    const chatMessages = document.getElementById("chat-messages");
    const userInput = document.getElementById("user-input");
    const sendButton = document.getElementById("send-btn");
    const loaderContainer = document.querySelector('.loader-container');
  


    sendButton.addEventListener("click", function() {
      const prompt = userInput.value;
      if (prompt.trim() !== "") {
        // showLoader();
        addUserMessage(prompt);
        sendRequestToBackend(prompt);
        userInput.value = "";
      }
    });
  
    function addUserMessage(message) {
      const chatMessage = document.createElement("div");
      chatMessage.classList.add("chat-message");
      chatMessage.innerHTML = `
        <p class="user">You</p>
        <span class="content">${message}</span>
      `;
      chatMessages.appendChild(chatMessage);
      chatMessages.scrollTop = chatMessages.scrollHeight;
    }
  
    function addBotMessage(message) {
      const chatMessage = document.createElement("div");
      chatMessage.classList.add("chat-message");
      chatMessage.innerHTML = `
        <p class="soumit">Soumit</p>
        <span class="content2">${message}</span>
      `;
      chatMessages.appendChild(chatMessage);
      chatMessages.scrollTop = chatMessages.scrollHeight;
    }
  
    function sendRequestToBackend(prompt) {
      const url = `http://localhost:8888/SoumitAI/chat?prompt=${encodeURIComponent(prompt)}`;
      fetch(url)
        .then(response => response.text())
        .then(data => addBotMessage(data))
        .catch(error => console.log(error));
    }
  });

  // sendButton.addEventListener('click', () => {
  //   const message = messageInput.value.trim();
  //   if (message !== '') {
  //     showLoader();
  //     sendMessage(message);
  //     messageInput.value = '';
  //   }
  // });
  
  // function showLoader() {
  //   loaderContainer.style.display = 'flex';
  // }
  
  // function hideLoader() {
  //   loaderContainer.style.display = 'none';
  // }