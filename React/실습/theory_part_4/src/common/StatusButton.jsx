const StatusButton = ({ text, isSelected, change }) => {  // 괄호 추가로 props 구조분해
    return (
        <button 
            onClick={change} 
            className='px-4 py-2 border border-slate-200 text-lg font-bold'
            style={{backgroundColor : isSelected ? "indigo" : "white"}}>
            {text}
        </button>
    );
};

export default StatusButton;