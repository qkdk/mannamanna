import { ChangeEvent, FormEvent, useEffect, useState } from "react";
import BackBox from "../../components/common/Back";
import MacBookBox from "../../components/common/macbookBox";
import { TextField, Button } from "@mui/material";
import SendIcon from "@mui/icons-material/Send";
import {
  ChatPeopleBox,
  LeftChatBox,
  RightChatBox,
  ChatProFile,
  ChatContainerBox,
  ChatLeftStyle,
  ChatRightStyle,
  ChatInBox,
  ChatPeopleOutBox,
  ChatOutBox,
  ChatInputBox,
} from "./ChattingStyle";
import SidebarChat from "../../components/layout/Sidebar/SidebarChat";
import { MyPageContainerBox } from "../User/MyPage/MyPageStyle";
import { useRecoilState } from "recoil";
import { ChattingRoomState, chatListState, genderAtom, idAtom, inputValueState } from "../../Recoil/State";
import CreateChattingClient from "../User/Login/Clinet";
import { useQuery } from "@tanstack/react-query";
import api from "../../apis/Api";
import { StyledButton } from "../User/Login/LoginStyle";
import { ChatPeople, GetChat, SendChat } from "./ChattingComponent";
import { ChatMessage } from "../../apis/Request/Request";
import { Client, Message } from "@stomp/stompjs";
import { SOCET_URL } from "../../apis/Url";



export const Chatting = () => {
  const [Userid, setId] = useRecoilState(idAtom);
  const [gender, setGender] = useRecoilState(genderAtom);
  const [RoomId, setRoomId] = useRecoilState(ChattingRoomState);
  const [inputValue, setInputValue] = useRecoilState(inputValueState); 
  const [chatList, setChatList] = useRecoilState(chatListState);

  const { data: ChattingInfo, isLoading, isError } = useQuery<any>(["ChattingInfo"], async () => {
    const response = await api.get(`chat/room/${Userid}`);
    console.log(response.data);
    return response.data.data;
  });
  // Handle input value change

  const EnterRoom = (ChattingRoom: number) => {
    console.log(ChattingRoom);
    setRoomId(ChattingRoom);
  };

    const Chat=CreateChattingClient();

    let messageContent = "";
  
    // }
    function getMessage() {
      Chat.client.subscribe(`/sub/chat/room/${RoomId}`, (body:Message) => {
        const message = JSON.parse(body.body) as ChatMessage;
        console.log(message);
        setChatList((chat_list) => [...chat_list, message]);
      });
    }

    Chat.client.activate();
    function publish(chat: ChatMessage) {
      console.log(chat.message);
      if (!Chat.client.connected) {
        return;
      }
      Chat.client.publish({
        destination: `/sub/chat/room${RoomId}`,
        body: JSON.stringify(chat),
      });
    }
    const handleInputChange = (message:string) => {
      messageContent=message;
    };
    function sendMessage() {
      const newChat: ChatMessage = {
        MessageType: "TALK",
        roomId:RoomId,
        sender:Userid,
        message:inputValue,
    };
      publish(newChat);
    }


     function handleSubmit(event: any) {
      event.preventDefault();
      setInputValue(messageContent); // 상태 업데이트
      if (inputValue === "") {
        return;
      }
      sendMessage();
      setInputValue("");

    }

  


    if (isLoading) {
      return <p>Loading...</p>;
    }
  
    if (isError) {
      return <p>에러입니다.</p>;
    }
  

  return (
    <div>
      <div style={{ height: "5vh" }}></div>
      <BackBox>
        <div style={{ height: "80vh" }}>
          <SidebarChat />
        </div>
        <div style={{ height: "80vh" }}>
          <MyPageContainerBox>
            <MacBookBox
              width="30%"
              height="90%"
              color1="#ffcced"
              color2="#ffffff"
              alignItems="center"
            >
              <ChatPeopleOutBox>
                <ChatInBox>
                {ChattingInfo.map((note:any, index:any) => (
              <ChatPeople
              userName={gender === "male" ? note.femaleId : note.maleId}
                onEnterRoom={() =>
                  EnterRoom(
                    note.id
                  )} />
                ))}
                <StyledButton onClick={() => console.log(inputValue)}>값좀보자</StyledButton>
                </ChatInBox>
              </ChatPeopleOutBox>
            </MacBookBox>
            <MacBookBox
              width="60%"
              height="90%"
              color1="#ffcced"
              color2="#ffffff"
              alignItems="center"
            >
              {/* 스크롤바 디자인 추가해야함 */}
              <ChatOutBox>
                <ChatInBox>
                  <GetChat />
                  <SendChat />
                </ChatInBox>
              </ChatOutBox>
              <ChatInputBox>
              <TextField
                  variant="filled"
                  color="secondary"
                  onChange={(e)=>handleInputChange(e.target.value)}
                  sx={{
                    width: "70%",
                    backgroundColor: "#ffcced",
                    borderRadius: "0.5vw",
                  }}
                />
                <Button
                  variant="contained"
                  sx={{ backgroundColor: "#ffcced" }}
                  onClick={handleSubmit}
                >
                  <SendIcon />
                </Button>
              </ChatInputBox>
            </MacBookBox>
          </MyPageContainerBox>
        </div>
      </BackBox>
    </div>
  );
};
