import random
num_users=int(input('type number of players'))
count_user=0
rolls_of_turn=0
user_score=[]
for i in range(num_users):
    user_score.append(0)
print(user_score)
rolls=True
rounds=True
def check_score():
    global user_score
    for i in user_score:
        if i>=100:
            winner=user_score.index(i)
            print('winner is',winner+1)
            break
def roll():
    global count_user,rolls_of_turn,user_score
    dice_roll=random.randrange(1,7)
    if dice_roll!=1:
        rolls_of_turn+=dice_roll
        print('user',(count_user+1), 'dice roll:',dice_roll,'total for round',rolls_of_turn)
        hold=input('do you want to hold')

        if hold.lower()=='yes' or hold.lower()=='y':
            user_score[count_user]+=rolls_of_turn
            rolls_of_turn=0
            count_user+=1
            rolls=False

    elif dice_roll==1:
        print('user',count_user+1, 'dice roll:',dice_roll, 'you lost all points for the round')
        user_score[count_user]+=0
        count_user+=1
        rolls_of_turn=0
        rolls=False
    print(user_score)
def round():
    global count_user, rolls_of_turn, user_score
    while count_user<num_users:
        while rolls==True and count_user<num_users:
            check_score()
            roll()
        check_score()
while rounds==True:
    round()
    check_score()
    count_user=0
