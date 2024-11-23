<template>
    <div class="chat-container">
        <div class="messages">
            <div v-for="(message, index) in messages" :key="index" class="message">
                <strong>{{ message.sender }}:</strong> {{ message.content }}
            </div>
        </div>
        <div class="chat-form">
            <input v-model="messageContent" @keyup.enter="sendMessage" placeholder="Type a message..." />
            <button @click="sendMessage">Send</button>
        </div>
    </div>
</template>

<script>
import SockJS from "sockjs-client";
import { Stomp } from "@stomp/stompjs";

export default {
    data() {
        return {
            messageContent: "",
            messages: [],
            stompClient: null,
            userName: "User", // You can set this dynamically or retrieve from login session
        };
    },
    mounted() {
        this.connect();
    },
    methods: {
        connect() {
            const socket = new SockJS("http://localhost:8081/chat");
            this.stompClient = Stomp.over(socket);

            this.stompClient.connect({}, frame => {
                console.log("Connected: " + frame);
               
            }, error => {
                console.error("Connection error: ", error);
            });

        },
        
    },
    
};
</script>

<style scoped>
.chat-container {
    display: flex;
    flex-direction: column;
    max-width: 400px;
    margin: 0 auto;
}

.messages {
    flex: 1;
    overflow-y: auto;
    max-height: 300px;
    padding: 10px;
    border: 1px solid #ccc;
    margin-bottom: 10px;
}

.message {
    margin-bottom: 10px;
}

.chat-form {
    display: flex;
    gap: 10px;
}

input {
    flex: 1;
    padding: 8px;
    border: 1px solid #ccc;
}

button {
    padding: 8px 16px;
    background-color: #4CAF50;
    color: white;
    border: none;
    cursor: pointer;
}

button:hover {
    background-color: #45a049;
}
</style>
