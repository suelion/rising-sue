from tkinter import *
## 함수 선언 부분 ##
former_point = [0,0]
def save_file():
    pass
def read_file():
    pass

def clickMouse(event) :
    """
    버튼을 누른 점 까지 선을 그림.
    왼쪽 마우스 버튼 - Red
    가운데 마우스버튼 - Green
    오른쪽 마우스 버튼 - Black
    :param event:
    :return:
    """
    global Canvas1, former_point

    if event.num == 1 :
        fill_color = "red"
    elif event.num == 2:
        fill_color = "green"
    elif event.num == 3 :
        fill_color = "black"

    Canvas1.create_line(former_point[0],former_point[1], event.x, event.y, fill = fill_color, width =2)
    former_point = [event.x, event.y]

def save_file():
    filename = filedialog.askopenfilename(filetypes=[("Text files", "*.jpg")])

def read_file():
    Canvas1.delete('all')

## 메인 코드 부분 ##
if __name__ == '__main__':
    window = Tk()
    window.geometry("400x400")
    global Canvas1
    Canvas1 = Canvas(window,
                     width=400,
                     height=400, offset='100,100')
    window.title("선그리기")
    #Canvas1.pack()
    Canvas1.bind("<Button>", clickMouse)
    button_save = Button(window, width = 10, height=1, text='Save', foreground = "black", command = save_file)
    button_save.configure(text = 'Save')
    button_save.place(x=200, y=370)

    button_read = Button(window, width = 10, height=1, text='Read', foreground = "black", command = read_file)
    button_read.configure(text='Read')
    button_read.place(x=300, y=370)
    Canvas1.pack()
    window.mainloop()

