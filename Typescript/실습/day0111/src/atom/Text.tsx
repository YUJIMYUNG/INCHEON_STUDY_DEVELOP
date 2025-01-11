type TextProps = {
    text : string;
    css?: React.CSSProperties;
}

const Text = ({ text, css }: TextProps) => {
    return (
        <div>
            <span style={css}>{text}</span>
        </div>
    );
};

export default Text;